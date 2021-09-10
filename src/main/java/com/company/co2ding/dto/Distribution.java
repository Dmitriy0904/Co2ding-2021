package com.company.co2ding.dto;

import com.company.co2ding.model.DataType;
import com.company.co2ding.model.Region;

import java.util.List;

public record Distribution(Region region, DataType dataType, List<ResultDTO> results) {
}
