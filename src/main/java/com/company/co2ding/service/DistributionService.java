package com.company.co2ding.service;

import com.company.co2ding.dto.DataTypeDTO;
import com.company.co2ding.dto.Distribution;
import com.company.co2ding.dto.RegionDTO;
import com.company.co2ding.dto.ResultDTO;
import com.company.co2ding.model.DataType;
import com.company.co2ding.model.Region;
import com.company.co2ding.model.Result;
import com.company.co2ding.repository.DataTypeRepository;
import com.company.co2ding.repository.RegionRepository;
import com.company.co2ding.repository.ResultRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.util.List;

@Service
public class DistributionService implements DistributionOperations {

    private final RegionRepository regionRepository;
    private final ResultRepository resultRepository;
    private final DataTypeRepository dataTypeRepository;

    public DistributionService(
            RegionRepository regionRepository,
            ResultRepository resultRepository,
            DataTypeRepository dataTypeRepository
    ) {
        this.regionRepository = regionRepository;
        this.resultRepository = resultRepository;
        this.dataTypeRepository = dataTypeRepository;
    }


    @Transactional(readOnly = true)
    public List<DataType> getDataTypes() {
        return dataTypeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Region> getRegions() {
        return regionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Distribution getResults(Integer year, Long regionId, Long dataTypeId) {
        Region region = regionRepository.findById(regionId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Region with id " + regionId + " does not exist."));
        DataType dataType = dataTypeRepository.findById(dataTypeId).orElseThrow(()->new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data type with id" + dataTypeId +" does not exist."));
        Date start = Date.valueOf(year + "-01-01");
        Date end = Date.valueOf(year + "-12-31");
        List<Result> results = resultRepository.findByRegionAndDate(regionId, start, end, dataTypeId);
        return new Distribution(new RegionDTO(region.getId(), region.getName()), new DataTypeDTO(dataType.getId(), dataType.getName(), dataType.getUnits()), ResultDTO.fromResults(results));
    }
}
