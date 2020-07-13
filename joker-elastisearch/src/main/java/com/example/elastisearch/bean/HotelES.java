package com.example.elastisearch.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;

@Document(indexName = "guide_hotel", type = "doc", shards = 1, replicas = 0)
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
     * 评分
     */
    @JsonProperty("grade")
    private String grade;



    /**
     * 酒店ID
     */
//    @TableField("hotelId")
    private Long hotelId;

    /**
     * 中文名
     */
//    @TableField("chineseName")
    private String chineseName;

    /**
     * 英文名
     */
//    @TableField("englishName")
    private String englishName;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getHotelid() {
        return hotelid;
    }

    public void setHotelid(Long hotelid) {
        this.hotelid = hotelid;
        this.hotelId = hotelid;
    }

    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename;
        this.chineseName = chinesename;
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname;
        this.englishName = englishname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }







    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }


    @Override
    public String toString() {
        return "HotelES{" +
                "id=" + id +
                ", hotelid=" + hotelid +
                ", chinesename='" + chinesename + '\'' +
                ", englishname='" + englishname + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", grade='" + grade + '\'' +
                ", hotelId=" + hotelId +
                ", chineseName='" + chineseName + '\'' +
                ", englishName='" + englishName + '\'' +
                '}';
    }
}
