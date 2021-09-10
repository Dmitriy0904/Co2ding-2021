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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class DistributionService {

    private RegionRepository regionRepository;
    private ResultRepository resultRepository;
    private DataTypeRepository dataTypeRepository;

    public DistributionService(RegionRepository regionRepository, ResultRepository resultRepository, DataTypeRepository dataTypeRepository) {
        this.regionRepository = regionRepository;
        this.resultRepository = resultRepository;
        this.dataTypeRepository = dataTypeRepository;
    }

    public List<Region> getAllRegions(){
        return regionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Distribution getResults(Integer year, Long regionId, Long dataTypeId){
        Region region = regionRepository.getById(regionId);
        DataType dataType = dataTypeRepository.getById(dataTypeId);
        Date start = Date.valueOf(year+"-01-01");
        Date end = Date.valueOf(year+"-12-31");
        List<Result> results = resultRepository.findByRegion_IdAndDateStartIsGreaterThanEqualAndDateStartIsLessThanEqualAndDataType_Id(regionId, start, end, dataTypeId)    ;
        return new Distribution(new RegionDTO(region.getId(), region.getName()),new DataTypeDTO(dataType.getId(), dataType.getName()), ResultDTO.fromResults(results));
    }
}
