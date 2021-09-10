package com.company.co2ding.csv;

import com.company.co2ding.model.Statistic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class Mapper {
    private final String csvPath = "co2.csv";
    private final ModelCreator creator;

    public Mapper(ModelCreator creator) {
        this.creator = creator;
    }

    public List<Statistic> mapObjects(){
        Map<String, String> headerValue = new HashMap<>();
        List<Statistic> statistics = new ArrayList<>();

        log.info("Starting to map objects. Initializing csv reader");
        CsvReader csvReader = new CsvReader();
        List<String[]> data = csvReader.readFile(csvPath);


        log.info("Starting to create objects");
        for(int i = 1; i < data.size(); i++){
            for(int j = 0; j < data.get(0).length; j++){
                headerValue.put(data.get(0)[j], data.get(i)[j]);
            }
            Statistic student = creator.createObject(Statistic.class, headerValue);
            log.info("Object {} was created successfully", student.toString());
            statistics.add(student);
        }

        log.info("Objects were mapped successfully");
        return statistics;
    }
}
