package com.company.co2ding.model;


import javax.persistence.*;

@Entity
@Table(name="generalInfo")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;

    private String region;

    private Integer month;

    private Double co2;

    private Double trees;

    public Statistic() {
    }

    public Statistic(Integer year, String region, Integer month, Double co2, Double trees) {
        this.year = year;
        this.region = region;
        this.month = month;
        this.co2 = co2;
        this.trees = trees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getCo2() {
        return co2;
    }

    public void setCo2(Double co2) {
        this.co2 = co2;
    }

    public Double getTrees() {
        return trees;
    }

    public void setTrees(Double trees) {
        this.trees = trees;
    }
}
