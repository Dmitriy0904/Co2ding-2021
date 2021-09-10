package com.company.co2ding.mapper;

import com.company.co2ding.csv.CsvMapper;
import com.company.co2ding.model.Region;
import com.company.co2ding.model.Result;
import com.company.co2ding.model.Statistic;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class Mapper {
    private final List<Statistic> statistics;

    public Mapper(CsvMapper csvMapper) {
        this.statistics = csvMapper.mapObjects();
    }


    public List<Region> mapRegions(){
        Set<String> cityNames = new HashSet<>();
        statistics.forEach(s -> cityNames.add(s.getRegion()));

        List<Region> regions = new ArrayList<>();

        for(String item : cityNames){
            Region region = RegionFactory.createRegion(item);
            regions.add(region);
        }
        return regions;
    }

//    public List<Result> mapResults(){
//        return null;
//    }

}