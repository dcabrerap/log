package com.dcabrera.utils.logging.loggingUtil;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

public class FileLoggerImpl implements Logger{
	
	private final static java.util.logging.Logger logger = java.util.logging.Logger.getLogger("fileLogger");
	private Level level;
	private String fileName;
	private String filePath;


	public void initialize() {
	    FileHandler fh;  

	    try {  

	        fh = new FileHandler(filePath+fileName);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
	        logger.setLevel(level);
	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
 
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
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
