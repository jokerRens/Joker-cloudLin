package com.example.elastisearch.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Document(indexName = "guide_hotel", type = "_doc", shards = 1, replicas = 0)
@JsonIgnoreProperties
public class HotelES {

    /**
     * id
     */
    @Id
    @JsonProperty("id")
    private Integer id;

    /**
     * 途牛酒店ID
     */
    @JsonProperty("hotelid")
    private Long hotelid;

    /**
     * 中文名
     */
    @JsonProperty("chinesename")
    private String chinesename;

    /**
     * 英文名
     */
    @JsonProperty("englishname")
    private String englishname;

    /**
     * 星级
     */
    @JsonProperty("star")
    private Integer star;

    /**
     * 酒店地址
     */
    @JsonProperty("address")
    private String address;

    /**
     * 起价
     */
    @JsonProperty("price")
    private BigDecimal price;

    /**
     * 1.国内 ， 2.国外
     */
    @JsonProperty("type")
    private Integer type;

    /**
     * 评分
     */
    @JsonProperty("grade")
    private String grade;

    /**
     * 起价排序
     */
    @JsonProperty("pricehot")
    private Integer pricehot;

    @Override
    public String toString() {
        return "HotelES{" +
                "id=" + id +
                ", hotelid=" + hotelid +
                ", chinesename='" + chinesename + '\'' +
                ", englishname='" + englishname + '\'' +
                ", star=" + star +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", grade='" + grade + '\'' +
                ", pricehot=" + pricehot +
                '}';
    }
}
