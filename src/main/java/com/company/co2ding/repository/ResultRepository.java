package com.company.co2ding.repository;

import com.company.co2ding.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
   @Query(value ="select r from Result r where r.region.id = :idRegion and r.datatype = :idDateType and YEAR(r.dateStart) = :year_ ", nativeQuery = true )
    List<Result> findAllByRegionName(Integer idRegion, Integer idDateType, Integer year_);
}
