package com.dcabrera.utils.logging.data;

import java.util.List;

import org.springframework.data.repository.Repository;



public interface LogRepository extends Repository<LogData, Integer> {
	
	LogData save(LogData log);
    List<LogData> findAll();
    LogData findOne(int id);	
}
