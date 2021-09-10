package com.company.co2ding.repository;

import com.company.co2ding.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    @Query(value = "select r from Region r limit 1", nativeQuery = true)
    Region findFirst();

    List<Region> findAll();
}
