package com.dcabrera.utils.logging.loggingUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggerFactory {
	
	@Autowired
	LoggerBuilder loggerBuilder;

	public Logger createLogger(LoggerType loggerType) {
		Logger logger = null;
		switch(loggerType) {
			case CONSOLE:
				logger = loggerBuilder.createConsoleLogger();
				break;
			case FILE:
				logger = loggerBuilder.createFileLogger();
				break;
			case DATABASE:
				logger = loggerBuilder.createDatabaseLogger();
				break;
		}
		return logger;
	}

}
