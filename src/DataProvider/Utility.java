package DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Utility
{
	public static String me(String key) throws IOException
	{
		FileInputStream m= new FileInputStream("D:\\eclipse\\data provider TestNG\\data.properties");
		
		Properties m1= new Properties();
		m1.load(m);
		
		String value = m1.getProperty(key);
		
		return value;
	}

}
