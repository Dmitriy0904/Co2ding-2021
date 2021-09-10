package com.company.co2ding.controller;

import com.company.co2ding.Routes;
<<<<<<< HEAD
import com.company.co2ding.service.db.DbOperations;
import com.sun.istack.Interned;
=======
import com.company.co2ding.dto.DataTypeDTO;
import com.company.co2ding.dto.Distribution;
import com.company.co2ding.dto.RegionDTO;
import com.company.co2ding.service.DistributionService;
>>>>>>> c1f7fa29e102e3470aa1117475b7bbfb8563748e
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import javax.annotation.PostConstruct;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Year;
import java.util.Calendar;

import static java.util.Calendar.YEAR;
=======
import java.util.List;
>>>>>>> c1f7fa29e102e3470aa1117475b7bbfb8563748e

@RestController
@RequestMapping(Routes.DISTRIBUTION)
public class MainController {

<<<<<<< HEAD
    private final DbOperations dbOperations;

    public MainController(DbOperations dbOperations) {
        this.dbOperations = dbOperations;
    }


    @PostConstruct
    public void init(){
        dbOperations.initEntities();
=======
    private DistributionService distributionService;

    public MainController(DistributionService distributionService) {
        this.distributionService = distributionService;
>>>>>>> c1f7fa29e102e3470aa1117475b7bbfb8563748e
    }


    @GetMapping(Routes.REGIONS)
    public List<RegionDTO> getRegions() {
        return RegionDTO.fromList(distributionService.getAllRegions());
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
