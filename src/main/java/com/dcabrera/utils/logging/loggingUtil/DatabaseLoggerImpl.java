package com.dcabrera.utils.logging.loggingUtil;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;

import com.dcabrera.utils.logging.data.LogData;
import com.dcabrera.utils.logging.data.LogDatabaseService;

public class DatabaseLoggerImpl implements Logger {
	private Level level;
	
	@Autowired
	private LogDatabaseService logDatabaseService;
	
	
	@Override
	public void error(String msg){
		if(level.equals(Level.ALL) || level.equals(Level.SEVERE) || 
				level.equals(Level.WARNING) || level.equals(Level.INFO)) {
			saveLog("ERROR", msg);

		}
			

	}

	@Override
	public void message(String msg) {
		if(level.equals(Level.ALL) || level.equals(Level.INFO)) {
			saveLog("INFO", msg);
		}
		
	}

	@Override
	public void warn(String msg) {
		if(level.equals(Level.ALL) ||level.equals(Level.WARNING) || level.equals(Level.INFO)) {
			saveLog("WARNING", msg);
		}
		
	}
	
	private void saveLog(String levelMsg, String msg) {
		LogData log = new LogData();
		log.setMessage(levelMsg+":"+DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + msg);
		logDatabaseService.save(log);		
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
