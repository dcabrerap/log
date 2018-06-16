package com.dcabrera.utils.logging.loggingUtil;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppProperties {


	@Value("${logging.fileAppender.level}")
	private String fileAppenderLevel;
	
	@Value("${logging.fileAppender.fileName}")
	private String fileAppenderFileName;
	
	@Value("${logging.fileAppender.filePath}")
	private String fileAppenderFilePath;
	
	@Value("${logging.consoleAppender.level}")
	private String consoleAppenderLevel;
	
	@Value("${logging.databaseAppender.level}")
	private String databaseAppenderLevel;
	
	public String getFileAppender_level() {
		return fileAppenderLevel;
	}
	public void setFileAppenderLevel(String fileAppenderLevel) {
		this.fileAppenderLevel = fileAppenderLevel;
	}
	public String getFileAppenderFileName() {
		return fileAppenderFileName;
	}
	public void setFileAppenderFileName(String fileAppenderFileName) {
		this.fileAppenderFileName = fileAppenderFileName;
	}
	public String getFileAppenderFilePath() {
		return fileAppenderFilePath;
	}
	public void setFileAppenderFilePath(String fileAppenderFilePath) {
		this.fileAppenderFilePath = fileAppenderFilePath;
	}
	public String getConsoleAppenderLevel() {
		return consoleAppenderLevel;
	}
	public void setConsoleAppenderLevel(String consoleAppenderLevel) {
		this.consoleAppenderLevel = consoleAppenderLevel;
	}
	public String getDatabaseAppenderLevel() {
		return databaseAppenderLevel;
	}
	public void setDatabaseAppenderLevel(String databaseAppenderLevel) {
		this.databaseAppenderLevel = databaseAppenderLevel;
	}	



}