package com.dcabrera.utils.logging.loggingUtil;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;


public class JobLogger {
	private static JobLogger instance;
	
	private JobLogger() {
		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("application.properties");
			prop.load(input);
			prop.getProperty("database");
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}		
	}
		
	public static synchronized JobLogger getLogger() {
        if(instance == null){
            instance = new JobLogger();
        }
		return instance;
	}
	
	public static void log(Level level, String message) {}
}
