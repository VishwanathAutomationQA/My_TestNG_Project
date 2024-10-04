package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGenerator {

	public static String randomString() {
		String randomString = RandomStringUtils.randomAlphabetic(5);
		 return randomString;
	}
	
	public static String randomNumber() {
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}
	
	public static String randomAlphaNumeric() {
		String randomString = RandomStringUtils.randomAlphabetic(5);
		String randomNumber = RandomStringUtils.randomNumeric(3);
		return (randomString+"@"+randomNumber);
	}
}
