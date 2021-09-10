package com.company.co2ding.dto;

import com.company.co2ding.model.Result;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public record ResultDTO(Date dateStart, Double value) {

    public static List<ResultDTO> fromResults(List<Result> results) {
        List<ResultDTO> resultList = new ArrayList<>();
        results.forEach(result-> resultList.add(new ResultDTO(result.getDateStart(), result.getValue())));
        return resultList;
    }
}
