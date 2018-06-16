package com.dcabrera.utils.logging.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogDatabaseServiceImpl implements LogDatabaseService{
	
	@Autowired
	private LogRepository logRepository;
	
	@Override
	public LogData save(LogData log) {
		return logRepository.save(log);
	}

	@Override
	public List<LogData> findAll() {
		return logRepository.findAll();
	}

	@Override
	public LogData findOne(int id) {
		return logRepository.findOne(id);
	}

}
