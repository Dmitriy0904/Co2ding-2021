package com.company.co2ding.repository;

import com.company.co2ding.model.DataType;
import com.company.co2ding.model.Region;
import com.company.co2ding.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByRegionAndDateStartIsGreaterThanEqualAndDateStartIsLessThanEqualAndDataType(Region region, Date start, Date end, DataType dataType);

    List<Result> findByRegion_IdAndDateStartIsGreaterThanEqualAndDateStartIsLessThanEqualAndDataType_Id(Long regionId, Date start, Date end, Long dataTypeId);
}
