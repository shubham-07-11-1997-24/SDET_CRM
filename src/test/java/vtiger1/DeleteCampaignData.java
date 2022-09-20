package vtiger1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import CRM.generic.DataType;
import CRM.generic.Excelutility;
import CRM.generic.FileUtility;
import CRM.generic.IConstantPath;
import CRM.generic.JavaUtility;
import CRM.generic.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteCampaignData {

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
		driver.findElement(By.xpath("//a[@href='javascript:confirmdelete(\"index.php%3Fmodule%3DCampaigns%26action%3DDelete%26record%3D181%26return_module%3DCampaigns%26return_action%3Dindex%26parenttab%3DMarketing%26return_viewname%3D29\")']")).click();
	    driver.switchTo().alert().accept();
	
	}    

}
