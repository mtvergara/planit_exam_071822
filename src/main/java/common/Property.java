package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {

	Properties properties;
	public Property(String mapFile) {
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(mapFile);
			properties.load(in);
			in.close();
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String ReadProperty(String key) {
		try {
			String value = properties.getProperty(key);
			return value;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "invalid key";
	}
}
