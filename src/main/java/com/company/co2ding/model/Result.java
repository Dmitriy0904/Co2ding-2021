package com.company.co2ding.model;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "result")
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant dateStart;

    private Double value;

}