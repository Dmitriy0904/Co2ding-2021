package com.company.co2ding.service.db;

import com.company.co2ding.mapper.Mapper;
import com.company.co2ding.model.DataType;
import com.company.co2ding.model.Region;
import com.company.co2ding.model.Result;
import com.company.co2ding.repository.DataTypeRepository;
import com.company.co2ding.repository.RegionRepository;
import com.company.co2ding.repository.ResultRepository;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DbService implements DbOperations{

    private final RegionRepository regionRepository;
    private final ResultRepository resultRepository;
    private final Mapper mapper;
    private final DataTypeRepository dataTypeRepository;


    public DbService(RegionRepository regionRepository, ResultRepository resultRepository, Mapper mapper, DataTypeRepository dataTypeRepository) {
        this.regionRepository = regionRepository;
        this.resultRepository = resultRepository;
        this.mapper = mapper;
        this.dataTypeRepository = dataTypeRepository;
    }

    @Override
    public void initEntities() {
        saveRegions();
        List<DataType> dataTypes = saveDataTypes();
        saveResults(dataTypes);
//        saveResults();
    }

    private List<DataType> saveDataTypes() {
        List<DataType> dataTypes = new ArrayList<>();
        DataType dataType = new DataType();
        dataType.setName("CO2");
        dataType.setUnits("tons");
        dataTypes.add(dataTypeRepository.save(dataType));

        DataType treeDataType = new DataType();
        treeDataType.setName("Trees");
        treeDataType.setUnits("pcs");
        dataTypes.add(dataTypeRepository.save(treeDataType));
        return dataTypes;
    }

    private void saveResults(List<DataType> dataTypes) {
        List<Result> cO2results = mapper.mapCO2Results(dataTypes);
        resultRepository.saveAll(cO2results);
        List<Result> treeResults = mapper.mapTreeResults(dataTypes);
        resultRepository.saveAll(treeResults);
    }

    private void saveRegions(){
        List<Region> regions = mapper.mapRegions();
        regionRepository.saveAll(regions);
    }


//    private void saveResults(){
//
//    }
}