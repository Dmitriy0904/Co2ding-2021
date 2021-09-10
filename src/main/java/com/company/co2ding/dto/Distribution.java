package com.company.co2ding.dto;

import java.util.List;

public record Distribution(RegionDTO region,
                           DataTypeDTO dataType,
                           List<ResultDTO> results) {
}
