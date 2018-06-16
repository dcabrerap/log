package com.dcabrera.utils.logging.data;

import java.util.List;

public interface LogDatabaseService {
	public LogData save(LogData log);
	public List<LogData> findAll();
	public LogData findOne(int id);

}
