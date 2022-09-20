package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import CRM.generic.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JSPractice {

	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	WebDriverUtility wubdriverutility= new WebDriverUtility();
	driver.manage().window().maximize();
	wubdriverutility.jsIntiallization(driver);
	wubdriverutility.openApplicationJS("http://rmgtestingserver:8888/");
	wubdriverutility.sendkeysUsingJS(driver.findElement(By.name("user_name")), "admin");
	wubdriverutility.sendkeysUsingJS(driver.findElement(By.name("user_password")), "admin");
	wubdriverutility.clickUsingJS(driver.findElement(By.id("submitButton")));
	wubdriverutility.scrollTitleElementusingJS(driver.findElement(By.xpath("//td[@class='homePageMatrixHdr']")));	
	
	}

}
