package com.company.co2ding.repository;

import com.company.co2ding.model.DataType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DataTypeRepository  extends JpaRepository<DataType, Long> {

    @Query(value = "select d from DataType d limit 1", nativeQuery = true)
    DataType findFirst();

    List<DataType> findAll();
}
