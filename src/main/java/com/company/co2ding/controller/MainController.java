package com.company.co2ding.controller;

import com.company.co2ding.Routes;
import com.company.co2ding.service.DistributionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Routes.DISTRIBUTION)
public class MainController {

    private DistributionService distributionService;

    public MainController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }


    @GetMapping(Routes.REGIONS)
    public void /*model*/ getRegions() {
        //doing something
    }


    @GetMapping(Routes.DATA_TYPES)
    public void /*model*/ getDataTypes() {
        //doing something
    }


    @GetMapping(Routes.SUMMARY)
    public void /*model*/ getSummary(
            @RequestParam /*@Min(1900) @Max(Calendar.getInstance().get(YEAR))*/ Integer year,
            @RequestParam Integer region,
            @RequestParam Integer dataType
    ) {
        //doing something
    }
}
