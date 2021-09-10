package com.company.co2ding.model;

import com.company.co2ding.csv.Mapped;

public class Statistic {

    @Mapped("year")
    private int year;

    @Mapped("month")
    private int month;

    @Mapped("region")
    private String region;

    @Mapped("co2, tons")
    private double co2;

    @Mapped("trees, pcs")
    private double trees;

    public Statistic() {
    }

    public Statistic(int year, int month, String region, double co2, double trees) {
        this.year = year;
        this.month = month;
        this.region = region;
        this.co2 = co2;
        this.trees = trees;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String getRegion() {
        return region;
    }

    public double getCo2() {
        return co2;
    }

    public double getTrees() {
        return trees;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public void setTrees(double trees) {
        this.trees = trees;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "year=" + year +
                ", month=" + month +
                ", region='" + region + '\'' +
                ", co2=" + co2 +
                ", trees=" + trees +
                '}';
    }
}
