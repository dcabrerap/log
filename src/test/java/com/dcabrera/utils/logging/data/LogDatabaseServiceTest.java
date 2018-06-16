package com.dcabrera.utils.logging.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(MockitoJUnitRunner.class)
public class LogDatabaseServiceTest {
	
	@Mock
	LogRepository logRepositoryMock;
	
	@InjectMocks
	@Autowired
	LogDatabaseServiceImpl logDatabaseService;
	
	
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void test(){
		LogData logData = new LogData();
		logData.setMessage("test");
		assertNotNull(logDatabaseService);
		when(logRepositoryMock.save(any(LogData.class))).thenReturn(logData);
		LogData test = logDatabaseService.save(logData);
		assertEquals(logData.getMessage(), test.getMessage());
	}
}
