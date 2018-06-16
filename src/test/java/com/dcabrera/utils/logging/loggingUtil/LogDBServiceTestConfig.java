package com.dcabrera.utils.logging.loggingUtil;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.dcabrera.utils.logging.data.LogDatabaseService;

@Profile("test")
@Configuration
public class LogDBServiceTestConfig {
    @Bean
    @Primary
    public LogDatabaseService logDatabaseServiceMock() {
        return Mockito.mock(LogDatabaseService.class);
    }
}