package com.company.co2ding.controller;

import com.company.co2ding.Routes;
import com.company.co2ding.service.DistributionOperations;
import com.company.co2ding.service.db.DbOperations;
import com.company.co2ding.dto.DataTypeDTO;
import com.company.co2ding.dto.Distribution;
import com.company.co2ding.dto.RegionDTO;
import com.company.co2ding.service.DistributionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Year;
import java.util.Calendar;

import static java.util.Calendar.YEAR;
import java.util.List;

@RestController
@RequestMapping(Routes.DISTRIBUTION)
public class MainController {

    private final DbOperations dbOperations;
    private final DistributionOperations distributionOperations;

    public MainController(DbOperations dbOperations_,
                          DistributionOperations distributionOperations_) {
        this.dbOperations = dbOperations_;
        this.distributionOperations = distributionOperations_;
    }

    @PostConstruct
    public void init(){
        dbOperations.initEntities();
    }

    @GetMapping(Routes.REGIONS)
    public List<RegionDTO> getRegions() {
        return RegionDTO.fromList(distributionOperations.getRegions());
    }


    @GetMapping(Routes.DATA_TYPES)
    public List<DataTypeDTO> getDataTypes() {
        return DataTypeDTO.fromList(distributionOperations.getDataTypes());
    }


    @GetMapping(Routes.SUMMARY)
    public Distribution getSummary(
            @RequestParam /*@Min(1900) @Max(Calendar.getInstance().get(YEAR))*/ Integer year,
            @RequestParam Long region,
            @RequestParam Long dataType
    ) {
        return distributionOperations.getResults(year, region, dataType);
    }
}
