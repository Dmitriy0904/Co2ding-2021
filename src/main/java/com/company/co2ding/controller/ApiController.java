package com.company.co2ding.controller;

import com.company.co2ding.dto.Distribution;
import com.company.co2ding.service.DistributionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    private DistributionService distributionService;

    public ApiController(DistributionService distributionService) {
        this.distributionService = distributionService;
    }

    @GetMapping("/distribution/summary")
    public Distribution getAll(@PathParam("year")Integer year, @PathParam("region") Long region, @PathParam("dataType") Long dataType ){
        return distributionService.getResults(year, region, dataType);
    }
}
