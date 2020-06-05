package com.example.elastisearch.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Book bean
 *
 * @Document    作用在类，标记实体类为文档对象，一般有两个属性
 * indexName：对应索引库名称    type：对应在索引库中的类型
 * shards：分片数量，默认5      replicas：副本数量，默认1
 *
 * @Id  作用在成员变量，标记一个字段作为id主键
 *
 * @Field   作用在成员变量，标记为文档的字段，并指定字段映射属性：
 *
 */
@Document(indexName = "item", type = "docs", shards = 1, replicas = 0)
public class Book {

    @Id
    private Integer id;
    private String name;
    private String title;
    private Double price;

    public Book() {

    }

    public Book(Integer id, String name, String title, Double price){
        this.id = id;
        this.name = name;
        this.title = title;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
