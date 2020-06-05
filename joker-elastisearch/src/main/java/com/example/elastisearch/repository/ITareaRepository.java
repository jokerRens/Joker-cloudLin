package com.example.elastisearch.repository;

import com.example.elastisearch.bean.Tarea;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 继承ElasticsearchRepository
 * 可以使用里面的方法
 */
public interface ITareaRepository extends ElasticsearchRepository<Tarea,Integer> {

    /**
     * 城市名称模糊查询
     * @param name
     * @return
     */
    List<Tarea> findAllByAreaNameLike(String name);


    /**
     * id
     * @param id
     * @return
     */
    List<Tarea> findAllById(Integer id);
}
