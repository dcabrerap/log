package com.dcabrera.utils.logging.loggingUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dcabrera.utils.logging.data.LogData;
import com.dcabrera.utils.logging.data.LogDatabaseService;
import com.dcabrera.utils.logging.data.LogRepository;


	@RunWith(SpringJUnit4ClassRunner.class)
	public class DBLoggerTest {
		private LogData logError;
		private LogData logWarn;
		private LogData logMessage;

		@Mock
		LogRepository logRepositoryMock;
		
		@Mock
		LogDatabaseService logDatabaseServiceMock;
		
		@Mock
		DatabaseLoggerImpl logger;
		
	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);
			logError = new LogData();
			logError.setId(1);
			logError.setMessage("test db error");
			
			logWarn = new LogData();
			logWarn.setId(2);
			logWarn.setMessage("test db warn");
			
			logMessage = new LogData();
			logMessage.setId(2);
			logMessage.setMessage("test db msg");			
			
	    }
		

		
		@Test
		public void logDBError(){
			when(logDatabaseServiceMock.save(any(LogData.class))).thenReturn(logError);
			when(logDatabaseServiceMock.findOne(any(Integer.class))).thenReturn(logError);			
			assertNotNull("logDatabaseServiceMock",logDatabaseServiceMock);
			assertNotNull("logger",logger);
			logger.error(logError.getMessage());
			LogData test = logDatabaseServiceMock.findOne(1);
			assertEquals(logError.getMessage(), test.getMessage());
		}
		
		@Test
		public void logDBWarn(){
			when(logDatabaseServiceMock.save(any(LogData.class))).thenReturn(logWarn);
			when(logDatabaseServiceMock.findOne(any(Integer.class))).thenReturn(logWarn);			
			assertNotNull("logDatabaseServiceMock",logDatabaseServiceMock);
			assertNotNull("logger",logger);
			logger.warn(logError.getMessage());
			LogData test = logDatabaseServiceMock.findOne(2);
			assertEquals(logWarn.getMessage(), test.getMessage());
		}
		
		@Test
		public void logDBMessage(){
			when(logDatabaseServiceMock.save(any(LogData.class))).thenReturn(logMessage);
			when(logDatabaseServiceMock.findOne(any(Integer.class))).thenReturn(logMessage);			
			assertNotNull("logDatabaseServiceMock",logDatabaseServiceMock);
			assertNotNull("logger",logger);
			logger.message(logError.getMessage());
			LogData test = logDatabaseServiceMock.findOne(3);
			assertEquals(logMessage.getMessage(), test.getMessage());
		}
	}