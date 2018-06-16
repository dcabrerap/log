package com.dcabrera.utils.logging.loggingUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileLoggerTest {
	
	@Autowired
	LoggerFactory loggerFactory;
	
	@Test
	public void fileLogErrorTest(){
		Logger logger = loggerFactory.createLogger(LoggerType.FILE);
		Assert.assertNotNull(logger);
		String msg = "log test error";
		logger.error(msg);
		String log = readLog();
		Assert.assertNotNull(log);
		Assert.assertTrue(log.toString().contains(msg));

	}
	
	@Test
	public void fileLogWarnTest(){
		Logger logger = loggerFactory.createLogger(LoggerType.FILE);
		Assert.assertNotNull(logger);
		String msg = "log test warning";
		logger.warn(msg);
		String log = readLog();
		Assert.assertNotNull(log);
		Assert.assertTrue(log.toString().contains(msg));

	}	
	
	@Test
	public void fileLogMsgTest(){
		Logger logger = loggerFactory.createLogger(LoggerType.FILE);
		Assert.assertNotNull(logger);
		String msg = "log test msg";
		logger.message(msg);
		String log = readLog();
		Assert.assertNotNull(log);
		Assert.assertTrue(log.toString().contains(msg));

	}	
	
	private String readLog() {
		BufferedReader reader = null;
		StringBuilder log = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader("D:/log.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String line = reader.readLine();
			while (line != null) {
				line = reader.readLine();
				log.append(line);				
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new AssertionError();
		}
		return log.toString();
	}

}
