package com.example.elastisearch;

import com.example.elastisearch.bean.Book;
import com.example.elastisearch.bean.HotelES;
import com.example.elastisearch.bean.Tarea;
import com.example.elastisearch.repository.IHotelRepository;
import com.example.elastisearch.repository.ITareaRepository;
import com.example.elastisearch.repository.ITestRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.metrics.avg.InternalAvg;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.FetchSourceFilter;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ElastisearchApplicationTests {

    @Autowired
    private ITestRepository testRepository;

    @Autowired
    private ITareaRepository tareaRepository;

    @Autowired
    private IHotelRepository hotelRepository;


    @Test
    void contextLoads(){   //添加
        Book book = new Book(1,"雨季不再来","三毛",34.00);
        testRepository.index(book);
    }

    @Test
    void indexList(){   //批量添加
        ArrayList<Book> list = new ArrayList<>();
        list.add(new Book(2,"梦里花落知多少","三毛",45.00));
        list.add(new Book(3,"解忧杂货店","东野圭吾",29.00));
        list.add(new Book(4,"白夜行","东野圭吾",66.00));
        list.add(new Book(5,"三国演义","罗贯中",88.00));
        testRepository.saveAll(list);
    }

    @Test
    void  query(){  //查找
        System.out.println("======================酒店检索========================");
        NativeSearchQueryBuilder queryBuilderHotel = new NativeSearchQueryBuilder();
        queryBuilderHotel.withQuery(QueryBuilders.matchQuery("chinesename","都舍"));
        Iterable<HotelES> searchH = hotelRepository.search(queryBuilderHotel.build());
        searchH.forEach(s->{
            System.out.println(s.toString());
        });

        System.out.println("======================城市模糊查询========================");

        NativeSearchQueryBuilder queryBuilders = new NativeSearchQueryBuilder();
        queryBuilders.withQuery(QueryBuilders.matchQuery("area_name","成都市"));

        Iterable<Tarea> search = tareaRepository.search(queryBuilders.build());
        search.forEach(s->{
            System.out.println(s.toString());
        });


//        List<Tarea> name = tareaRepository.findAllByAreaNameLike("成都");
//        name.forEach(s->{
//            System.out.println(s.toString());
//        });

//        List<Tarea> allById = tareaRepository.findAllById(510100);
//        allById.forEach(s->{
//            System.out.println(s.toString());
//        });


        System.out.println("======================姓名模糊查询========================");
        List<Book> like = testRepository.findAllByNameLike("夜行");  //姓名模糊查询
        like.forEach(s->{
            System.out.println(s.toString());
        });

        System.out.println("======================价格升序========================");
        Iterable<Book> price = testRepository.findAll(Sort.by("price").ascending());    //价格升序
        price.forEach(p->{
            System.out.println(p.toString());
        });

        System.out.println("======================价格区间查询========================");
        List<Book> priceBetween = testRepository.findByPriceBetween(40.00, 80.00);  //价格区间查询
        priceBetween.forEach(b->{
            System.out.println(b.toString());
        });

        System.out.println("======================自定义查询*作者:三毛========================");
        //构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder(); //Spring提供的一个查询条件构建器，帮助构建json格式的请求体
        //添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title","三毛"));//利用QueryBuilders来生成一个查询。QueryBuilders提供了大量的静态方法，用于生成各种不同类型的查询
        //搜索、获取结果
        Page<Book> page = testRepository.search(queryBuilder.build());  //默认是分页查询，因此返回的是一个分页的结果对象，包含属性、1.totalElements：总条数、2.totalPages：总页数
        //总条数
        long total = page.getTotalElements();
        System.out.println("总条数:"+total);
        page.forEach(pa->{
            System.out.println(pa.toString());
        });
    }

    @Test
    void searchPage(){  //分页   与   排序
        //构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        //添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("title","三毛"));  //termQuery:功能更强大，除了匹配字符串意外，还可以匹配int/long/double/float/....

        // 分页：
        int page = 0;
        int size = 1;
        queryBuilder.withPageable(PageRequest.of(page,size));

        // 排序
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.ASC));

        //搜索    获取结果
        Page<Book> search = testRepository.search(queryBuilder.build());
        long total = search.getTotalElements();
        System.out.println("总条数 = " + total);
        // 总页数
        System.out.println("总页数 = " + search.getTotalPages());
        // 当前页
        System.out.println("当前页：" + search.getNumber());
        // 每页大小
        System.out.println("每页大小：" + search.getSize());

        search.forEach(sea->{
            System.out.println(sea.toString());
        });
    }


    @Test
    void jokerAgg(){    //聚合
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));

        //1.添加一个新的聚合，聚合类型为terms，聚合名称为titles，聚合字段为title
        queryBuilder.addAggregation(AggregationBuilders.terms("titles").field("title"));    //AggregationBuilders 聚合的构建工厂类。所有聚合都由这个类来构建

        //2.查询，需要把结果强转为AggregatedPage类型
        AggregatedPage<Book> search =  (AggregatedPage<Book>)testRepository.search(queryBuilder.build());   //AggregatedPage   聚合查询的结果类。它是Page<T>的子接口
        //AggregatedPage在Page功能的基础上，拓展了与聚合相关的功能，它其实就是对聚合结果的一种封装。


        //3.解析
        //3.1从结果中取出brands的那个聚合，// 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms brands = (StringTerms)search.getAggregation("titles");

        //3.2获取桶
        List<StringTerms.Bucket> list = brands.getBuckets();

        //3.3遍历
        list.forEach(agg->{
            // 3.4、获取桶中的key，即品牌名称
            System.out.println(agg.getKeyAsString());
            // 3.5、获取桶中的文档数量
            System.out.println(agg.getDocCount());
        });
    }

    @Test
    void  jokerSubAgg(){        //嵌套聚合 求平均值
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //不查询任何结果
        queryBuilder.withSourceFilter(new FetchSourceFilter(new String[]{""}, null));

        //1.添加一个新的聚合，聚合类型为terms，聚合名称为titles，聚合字段为title
        queryBuilder.addAggregation(AggregationBuilders.terms("titles").field("title")
                .subAggregation(AggregationBuilders.avg("priceAvg").field("price")));// 在品牌聚合桶内进行嵌套聚合，求平均值

        //2.查询，需要把结果强转为AggregatedPage类型
        AggregatedPage<Book> search =  (AggregatedPage<Book>)testRepository.search(queryBuilder.build());
        //AggregatedPage在Page功能的基础上，拓展了与聚合相关的功能，它其实就是对聚合结果的一种封装。

        //3.解析
        //3.1从结果中取出brands的那个聚合，// 因为是利用String类型字段来进行的term聚合，所以结果要强转为StringTerm类型
        StringTerms brands = (StringTerms)search.getAggregation("titles");

        //3.2获取桶
        List<StringTerms.Bucket> list = brands.getBuckets();

        //3.3遍历
        list.forEach(li->{
            // 3.4、获取桶中的key，即作者姓名  3.5、获取桶中的出书数量
            System.out.println(li.getKeyAsString() + "，共出书" + li.getDocCount() + "本");

            // 3.6.获取子聚合结果：
            InternalAvg avg = (InternalAvg)li.getAggregations().asMap().get("priceAvg");
            System.out.println("平均书价为:"+avg.getValue());
        });

    }





}
