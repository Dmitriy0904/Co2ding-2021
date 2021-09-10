package com.company.co2ding.controller;

import com.company.co2ding.Routes;
import com.company.co2ding.service.db.DbOperations;
import com.sun.istack.Interned;
import com.company.co2ding.dto.DataTypeDTO;
import com.company.co2ding.dto.Distribution;
import com.company.co2ding.dto.RegionDTO;
import com.company.co2ding.service.DistributionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(Routes.DISTRIBUTION)
public class MainController {

    private final DbOperations dbOperations;
    private final DistributionService distributionService;

    public MainController(DbOperations dbOperations, DistributionService distributionService1) {
        this.dbOperations = dbOperations;
        this.distributionService = distributionService1;
    }


    @PostConstruct
    public void init(){
        dbOperations.initEntities();
    }


    @GetMapping(Routes.REGIONS)
    public List<RegionDTO> getRegions() {
        return RegionDTO.fromList(distributionService.getRegions());
    }


    @GetMapping(Routes.DATA_TYPES)
    public List<DataTypeDTO> getDataTypes() {
        return DataTypeDTO.fromList(distributionService.getDataTypes());
    }


    @GetMapping(Routes.SUMMARY)
    public Distribution getSummary(
            @RequestParam /*@Min(1900) @Max(Calendar.getInstance().get(YEAR))*/ Integer year,
            @RequestParam Long region,
            @RequestParam Long dataType
    ) {
        return distributionService.getResults(year, region, dataType);
    }
}
