package com.company.co2ding.dto;

import com.company.co2ding.model.DataType;

import java.util.ArrayList;
import java.util.List;

public record DataTypeDTO(Long id, String name, String units) {
    public static List<DataTypeDTO> fromList(List<DataType> dataTypes) {
        List<DataTypeDTO> result = new ArrayList<>();
        dataTypes.forEach(dataType -> result.add(new DataTypeDTO(dataType.getId(), dataType.getName(), dataType.getUnits())));
        return result;
    }
}
