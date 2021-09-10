package com.company.co2ding.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class CsvReader {

    public List<String[]> readFile(String path){
        List<String[]> info;

        log.info("Try to read from csv file: {}", path);

        try(CSVReader reader = new CSVReader(new FileReader(path))) {

            info = reader.readAll();

        } catch (FileNotFoundException exception) {
            log.error("FileNotFoundException in read csv file: {}", path);
            throw new RuntimeException(exception);

        } catch (IOException exception) {
            log.error("IOException in read csv file: {}", path);
            throw new RuntimeException(exception);

        } catch (CsvException exception) {
            log.error("CsvException in read csv file: {}", path);
            throw new RuntimeException(exception);
        }

        log.info("Data from file was read successfully");
        return info;
    }
}
