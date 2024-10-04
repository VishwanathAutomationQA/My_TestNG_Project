package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadTestData {

	public static String readPropFile(String key) throws IOException {
		String path = System.getProperty("user.dir");
//		FileInputStream file = new FileInputStream(path+File.separator+ "testdata"+File.separator+"data.properties");
		FileReader file = new FileReader(path+File.separator+ "testdata"+File.separator+"data.properties");
		Properties prop = new Properties();
		prop.load(file);
		String value = prop.getProperty(key);
		file.close();
		return value;
	}
}