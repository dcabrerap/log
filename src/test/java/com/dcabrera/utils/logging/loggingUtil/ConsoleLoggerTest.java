package com.dcabrera.utils.logging.loggingUtil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsoleLoggerTest {
	

	@Autowired
	LoggerFactory loggerFactory;
	
	@Test
	public void ConsoleLogErrorTest(){		
		String testMsg = "console log error test message";		
		validateOut(testMsg);
	}
	
	@Test
	public void ConsoleLogWarnTest(){		
		String testMsg = "console log warning test message";		
		validateOut(testMsg);
	}
	
	
	@Test
	public void ConsoleLogMessageTest(){		
		String testMsg = "console log message test text";	
		validateOut(testMsg);
 
	}
	
	private void validateOut(String msg) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(baos);
		PrintStream initialOut = System.out;
		System.setOut(out);
		Logger consoleLogger = loggerFactory.createLogger(LoggerType.CONSOLE);
		consoleLogger.error(msg);
		System.out.flush();
		try {
			Assert.assertTrue(baos.toString().contains(msg));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError();
		}
		System.setOut(initialOut);
	}
	
}
