package com.company.co2ding.service.db;

import com.company.co2ding.mapper.Mapper;
import com.company.co2ding.model.Region;
import com.company.co2ding.repository.RegionRepository;
import com.company.co2ding.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService implements DbOperations{

    private final RegionRepository regionRepository;
    private final ResultRepository resultRepository;
    private final Mapper mapper;

    public DbService(
            RegionRepository regionRepository,
            ResultRepository resultRepository,
            Mapper mapper
    ) {
        this.regionRepository = regionRepository;
        this.resultRepository = resultRepository;
        this.mapper = mapper;
    }

    @Override
    public void initEntities() {
        saveRegions();
//        saveResults();
    }

    private void saveRegions(){
        List<Region> regions = mapper.mapRegions();
        for(Region item: regions){
            regionRepository.save(item);
        }
    }


//    private void saveResults(){
//
//    }
}