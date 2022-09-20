package vtiger1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import CRM.generic.DataType;
import CRM.generic.Excelutility;
import CRM.generic.FileUtility;
import CRM.generic.IConstantPath;
import CRM.generic.JavaUtility;
import CRM.generic.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditCampaign {

	public static void main(String[] args) throws IOException {
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
		
		WebDriver driver=null;
		driver = webDriverUtility.OpenBrowserWithApplication(browser, timeouts, url);
		driver.findElement(By.name("user_name")).sendKeys(username,Keys.TAB);
		driver.findElement(By.name("user_password")).sendKeys(password,Keys.ENTER);
		Actions action =new Actions(driver);
		WebElement morelink = driver.findElement(By.xpath("//a/img[@style=\"padding-left:5px\"]"));
		action.moveToElement(morelink).build().perform();
		driver.findElement(By.name("Campaigns")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Campaigns&action=EditView&record=46&return_module=Campaigns&return_action=index&parenttab=Marketing&return_viewname=29']")).click();
		driver.findElement(By.name("campaignname")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		String camp_name = eu.getDataFromExcel(IConstantPath.EXCE_PATH, "CAMPAIGN", 14, 2);
		driver.findElement(By.name("campaignname")).sendKeys(camp_name,Keys.TAB);
		driver.findElement(By.name("sponsor")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		String sponsor= eu.getDataFromExcel(IConstantPath.EXCE_PATH, "CAMPAIGN", 14, 3);
		driver.findElement(By.name("sponsor")).sendKeys(sponsor,Keys.TAB);
		driver.findElement(By.name("targetaudience")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		String target_audience = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 14, 4);
		driver.findElement(By.name("targetaudience")).sendKeys(target_audience,Keys.TAB);
		String campaign_type = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 14, 5);
		WebElement ele1 = driver.findElement(By.name("campaigntype"));
	    Select s1 = new Select(ele1);
	    s1.selectByIndex(5);
	    String campaign_status = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 14, 6);
	    WebElement ele= driver.findElement(By.name("campaignstatus"));
		   Select s2 = new Select(ele);
		    s2.selectByIndex(3);
		    driver.findElement(By.name("closingdate")).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		    String expected_close_date = eu.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 14, 8);
		    driver.findElement(By.name("closingdate")).sendKeys(expected_close_date,Keys.ENTER);
		
	}

}
