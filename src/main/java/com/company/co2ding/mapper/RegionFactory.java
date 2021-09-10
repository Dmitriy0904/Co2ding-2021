package com.company.co2ding.mapper;

import com.company.co2ding.model.Region;

public final class RegionFactory {
    public static Region createRegion(String city){
        return new Region(city);
    }
}
