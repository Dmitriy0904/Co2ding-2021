package com.company.co2ding.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="summary")
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Region region;

    @ManyToOne
    private DataType dataType;

    @OneToMany
    private List<Result> results;

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }
}
