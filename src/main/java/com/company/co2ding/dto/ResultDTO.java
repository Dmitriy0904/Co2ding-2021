package com.company.co2ding.dto;

import com.company.co2ding.model.Result;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public record ResultDTO(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Instant dateStart,
                        Double value) {

    public static List<ResultDTO> fromResults(List<Result> results) {
        List<ResultDTO> resultList = new ArrayList<>();
        results.forEach(result -> resultList.add(new ResultDTO(result.getDateStart(), result.getValue())));
        return resultList;
    }
}
