package CRM.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist reuseable method to handle property file
 * 
 * @author BHARDWAJ
 *
 */

public class FileUtility {
	Properties pro;
    //changes by engg1 bvgyuctyctyvfyubgiu
	public String getDataFromPropertyFile(String key) {
		return pro.getProperty(key).trim();
	}
      //changes
	public void initializePropertyFile(String filePath) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		pro = new Properties();
		pro.load(file);
	}

}
