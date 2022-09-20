package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import CRM.generic.DataType;
import CRM.generic.Excelutility;
import CRM.generic.FileUtility;
import CRM.generic.IConstantPath;
import CRM.generic.JavaUtility;
import CRM.generic.WebDriverUtility;

public class Practice_webElement {

	public static void main(String[] args) throws IOException {
		//comment
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		FileUtility fu = new FileUtility();
		JavaUtility javautility = new JavaUtility();
		Excelutility eu= new Excelutility();
		fu.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		String url = fu.getDataFromPropertyFile("url");
		String username = fu.getDataFromPropertyFile("username");
		String password = fu.getDataFromPropertyFile("password");
		String browser = fu.getDataFromPropertyFile("browser");
		String timeout = fu.getDataFromPropertyFile("timeout");
		long timeouts = (long)javautility.convertToAnyDataType(timeout,DataType.LONG);
		
		WebDriver driver = webDriverUtility.OpenBrowserWithApplication(browser, timeouts, url);
		driver.findElement(By.name("user_name")).sendKeys(username,Keys.TAB);
		driver.findElement(By.name("user_password")).sendKeys(password,Keys.ENTER);
		
	    Actions action =new Actions(driver);
		WebElement morelink = driver.findElement(By.xpath("//a/img[@style=\"padding-left:5px\"]"));
		action.moveToElement(morelink).build().perform();
		driver.findElement(By.name("Campaigns")).click();
	    driver.findElement(By.xpath("//a/img[@alt=\"Create Campaign...\"]")).click();
	    
	    String camp_name = eu.getDataFromExcel(IConstantPath.EXCE_PATH, "CAMPAIGN", 13, 2);
	   String sponsor= eu.getDataFromExcel(IConstantPath.EXCE_PATH, "CAMPAIGN", 13, 3);
	   String target_audience = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 13, 4);
	   String campaign_type = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 13, 5);
	   String campaign_status = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 13, 6);
	   String expected_revenue = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 13, 7);
	   String expected_close_date = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 13, 8);
	   String assigned_to = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 13, 9);
	   
	   driver.findElement(By.name("campaignname")).sendKeys(camp_name,Keys.TAB);
	   driver.findElement(By.name("sponsor")).sendKeys(sponsor,Keys.TAB);
	   driver.findElement(By.name("targetaudience")).sendKeys(target_audience,Keys.TAB);
	   WebElement ele= driver.findElement(By.name("campaignstatus"));
	   Select s1 = new Select(ele);
	    s1.selectByIndex(3);
	    WebElement ele1 = driver.findElement(By.name("campaigntype"));
	    Select s2 = new Select(ele1);
	    s1.selectByIndex(2);
	    driver.findElement(By.name("expectedrevenue")).sendKeys(expected_revenue,Keys.TAB);
	   // driver.findElement(By.name("closingdate")).sendKeys(expected_close_date,Keys.ENTER);
	    
	  
	}

}
