package com.company.co2ding.controller;

import com.company.co2ding.Routes;
import com.company.co2ding.service.db.DbOperations;
import com.sun.istack.Interned;
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

@RestController
@RequestMapping(Routes.DISTRIBUTION)
public class MainController {

    private final DbOperations dbOperations;

    public MainController(DbOperations dbOperations) {
        this.dbOperations = dbOperations;
    }


    @PostConstruct
    public void init(){
        dbOperations.initEntities();
    }


    @GetMapping(Routes.REGIONS)
    public void /*model*/ getRegions(){
        //doing something
    }


    @GetMapping(Routes.DATA_TYPES)
    public void /*model*/ getDataTypes(){
        //doing something
    }


    @GetMapping(Routes.SUMMARY)
    public void /*model*/ getSummary(
            @RequestParam /*@Min(1900) @Max(Calendar.getInstance().get(YEAR))*/ Integer year,
            @RequestParam Integer region,
            @RequestParam Integer dataType
    ){
        //doing something
    }
}
