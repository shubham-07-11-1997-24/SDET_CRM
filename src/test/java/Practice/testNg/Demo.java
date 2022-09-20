package Practice.testNg;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import CRM.generic.WebDriverUtility;

public class Demo {

	@Test
	public void test() {
		String browser = System.getProperty("b");
		String url = System.getProperty("u");

		System.out.println("broswer is = " + browser);
		System.out.println("url is = " + url);
		WebDriverUtility webDriverUtility = new WebDriverUtility();

		WebDriver driver = webDriverUtility.OpenBrowserWithApplication(browser,(long)100, url);
	}
}
