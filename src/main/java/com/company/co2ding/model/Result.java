package com.company.co2ding.model;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "results")
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant dateStart;

    private Double value;

    @ManyToOne
    private DataType dataType;

    @ManyToOne
    private Region region;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateStart() {
        return dateStart;
    }

    public void setDateStart(Instant dateStart) {
        this.dateStart = dateStart;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}