package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("src/test/resources/Testdata.properties");
		Properties property= new Properties();
		property.load(fis);
		String url=property.getProperty("url").trim();
		String browser=property.getProperty("browser");
		String username=property.getProperty("username");
		String password=property.getProperty("password");
		System.out.println(url);
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);

	}

}
