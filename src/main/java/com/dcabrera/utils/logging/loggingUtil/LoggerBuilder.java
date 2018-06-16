package com.dcabrera.utils.logging.loggingUtil;

import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggerBuilder {
	
	@Autowired
	AppProperties properties;
	

	

	public  Logger createFileLogger() {
		FileLoggerImpl fileLogger = new FileLoggerImpl();
		fileLogger.setLevel(Level.parse(properties.getFileAppender_level()));
		fileLogger.setFileName(properties.getFileAppenderFileName());
		fileLogger.setFilePath(properties.getFileAppenderFilePath());
		fileLogger.initialize();
		return fileLogger;
	}
	
	public  Logger createConsoleLogger() {
		ConsoleLoggerImpl consoleLogger = new ConsoleLoggerImpl();
		consoleLogger.setLevel(Level.parse(properties.getConsoleAppenderLevel()));
		consoleLogger.initialize();
		return consoleLogger;
	}
	
	public  Logger createDatabaseLogger() {
		DatabaseLoggerImpl dbLogger = new DatabaseLoggerImpl();
		dbLogger.setLevel(Level.parse(properties.getDatabaseAppenderLevel()));
		return dbLogger;
	}
}
