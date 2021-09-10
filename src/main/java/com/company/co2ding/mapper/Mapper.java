package com.company.co2ding.mapper;

import com.company.co2ding.csv.CsvMapper;
import com.company.co2ding.model.DataType;
import com.company.co2ding.model.Region;
import com.company.co2ding.model.Result;
import com.company.co2ding.model.Statistic;
import com.company.co2ding.repository.RegionRepository;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;

@Component
public class Mapper {
    private final List<Statistic> statistics;

    private RegionRepository regionRepository;

    public Mapper(CsvMapper csvMapper, RegionRepository regionRepository) {
        this.statistics = csvMapper.mapObjects();
        this.regionRepository = regionRepository;
    }

    public List<Region> mapRegions(){
        Set<String> cityNames = new LinkedHashSet<>();
        statistics.forEach(s -> cityNames.add(s.getRegion()));

        List<Region> regions = new ArrayList<>();

        for(String item : cityNames){
            Region region = RegionFactory.createRegion(item);
            regions.add(region);
        }
        return regions;
    }

    public List<Result> mapCO2Results(List<DataType> dataTypes){
        List<Result> results = new ArrayList<>();
        DataType dataType = dataTypes.get(0);
        statistics.forEach(s-> {
            Date date = Date.valueOf(s.getYear()+"-"+s.getMonth()+"-01");
            Result result = new Result(date, s.getCo2(), dataType, regionRepository.findByName(s.getRegion()));
            results.add(result);});
        return results;
    }

    public List<Result> mapTreeResults(List<DataType> dataTypes){
        List<Result> results = new ArrayList<>();
        DataType dataType = dataTypes.get(1);
        dataType.setName("Trees");
        dataType.setUnits("pcs");
        statistics.forEach(s-> {
            Date date = Date.valueOf(s.getYear()+"-"+s.getMonth()+"-01");
            Result result = new Result(date, s.getTrees(), dataType, regionRepository.findByName(s.getRegion()));
            results.add(result);});
        return results;
    }

}