package com.example.elastisearch.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "mysql_guide", type = "_doc", shards = 1, replicas = 0)
@JsonIgnoreProperties
public class Tarea {

    @Id
    private Integer id;

    /**
     * 市名
     */
    @JsonProperty("area_name")
    private String areaName;

    /**
     * 父ID
     */
    @JsonProperty("parent_id")
    private Long parentId;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 类型
     */
    private String type;

    /**
     * 排序
     */
    private int top;

    /**
     * logo
     */
    private String sort;

    /**
     * 热门城市
     */
    private String hot;

    /**
     * 国ID
     */
    @JsonProperty("country_id")
    private Long countryId;

    /**
     * 州ID
     */
    @JsonProperty("continent_id")
    private Long continentId;

    /**
     * 封面
     */
    private String image;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    public Tarea() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public Long getContinentId() {
        return continentId;
    }

    public void setContinentId(Long continentId) {
        this.continentId = continentId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                ", parentId=" + parentId +
                ", zipcode='" + zipcode + '\'' +
                ", type='" + type + '\'' +
                ", top=" + top +
                ", sort='" + sort + '\'' +
                ", hot='" + hot + '\'' +
                ", countryId=" + countryId +
                ", continentId=" + continentId +
                ", image='" + image + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
