package com.company.co2ding.repository;

import com.company.co2ding.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import java.sql.Date;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

        List<Result> findByRegion_IdAndDateStartIsGreaterThanEqualAndDateStartIsLessThanEqualAndDataType_Id(Long regionId,
                                                                                                            Date start,
                                                                                                            Date end,
                                                                                                            Long dataTypeId);
    }
