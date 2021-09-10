package com.company.co2ding.dto;

import com.company.co2ding.model.Region;

import java.util.ArrayList;
import java.util.List;

public record RegionDTO(Long id, String name) {
    public static List<RegionDTO> fromList(List<Region> allRegions) {
        List<RegionDTO> result = new ArrayList<>();
        allRegions.forEach(region -> result.add(new RegionDTO(region.getId(), region.getName())));
        return result;
    }
}
