package com.dcabrera.utils.logging.loggingUtil;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public class ConsoleLoggerImpl implements Logger {
	private final static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("fileLogger");
	private Level level;
	
	public void initialize() {
		ConsoleHandler ch = new ConsoleHandler();
		logger.addHandler(ch);
		logger.setLevel(level);
	}

	@Override
	public void error(String msg) {
		logger.log(Level.SEVERE, msg);
		
	}

	@Override
	public void message(String msg) {
		logger.log(Level.INFO, msg);
	}

	@Override
	public void warn(String msg) {
		logger.log(Level.WARNING, msg);
		
	}
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}
