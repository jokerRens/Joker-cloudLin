package com.example.elastisearch.repository;

import com.example.elastisearch.bean.HotelES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 继承ElasticsearchRepository
 * 可以使用里面的方法
 */
public interface IHotelRepository extends ElasticsearchRepository<HotelES,Integer> {



}
