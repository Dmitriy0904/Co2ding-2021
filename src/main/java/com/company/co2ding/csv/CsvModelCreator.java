package com.company.co2ding.csv;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Component
@Slf4j
public class CsvModelCreator {

    private final CsvFieldParser parser;

    public CsvModelCreator(CsvFieldParser parser) {
        this.parser = parser;
    }

    public <T> T createObject(Class<T> objectClass, Map<String, String> csvValues){
        T newObject;
        log.info("Try to create new object");
        try {
            newObject = objectClass.getDeclaredConstructor().newInstance();

            log.info("Get object fields");
            Field[] objectFields = objectClass.getDeclaredFields();


            for(Field field : objectFields){
                if(field.isAnnotationPresent(CsvMapped.class)){
                    field.setAccessible(true);
                    CsvMapped fieldAnnotation = field.getAnnotation(CsvMapped.class);
                    String annotationValue = csvValues.get(fieldAnnotation.value());
                    parser.parseField(newObject, field, annotationValue);
                }
            }

        } catch (NoSuchMethodException exception) {
            log.error("NoSuchMethodException in method create object");
            throw new RuntimeException(exception);
        } catch (IllegalAccessException exception) {
            log.error("IllegalAccessException in method create object");
            throw new RuntimeException(exception);
        } catch (InstantiationException exception) {
            log.error("InstantiationException in method create object");
            throw new RuntimeException(exception);
        } catch (InvocationTargetException exception) {
            log.error("InvocationTargetException in method create object");
            throw new RuntimeException(exception);
        }

        log.info("Object {} was created successfully", newObject.toString());
        return newObject;
    }
}
