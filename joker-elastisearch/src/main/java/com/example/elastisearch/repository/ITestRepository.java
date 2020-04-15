package com.example.elastisearch.repository;

import com.example.elastisearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 继承ElasticsearchRepository
 * 可以使用里面的方法
 */
public interface ITestRepository extends ElasticsearchRepository<Book,Integer> {

    /**
     * 书名模糊查询
     * @param name
     * @return
     */
     List<Book> findAllByNameLike(String name);

    /**
     * 按照价格区间查找
     * @param priceStart
     * @param priceEnd
     * @return
     */
     List<Book> findByPriceBetween (Double priceStart, Double priceEnd);


}
