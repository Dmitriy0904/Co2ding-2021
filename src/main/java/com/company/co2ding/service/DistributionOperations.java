package com.company.co2ding.service;

import com.company.co2ding.dto.Distribution;
import com.company.co2ding.model.DataType;
import com.company.co2ding.model.Region;

import java.util.List;

public interface DistributionOperations {
    List<DataType> getDataTypes();

    List<Region> getRegions();

    Distribution getResults(Integer year, Long regionId, Long dataTypeId);
}
