package vtiger1;

import java.io.IOException;

import org.openqa.selenium.By;
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
import CRM_sdet40_objectRepository.CampaignPage;
import CRM_sdet40_objectRepository.CommonPage;
import CRM_sdet40_objectRepository.CreateCampaignPage;
import CRM_sdet40_objectRepository.LoginPage;

public class Campaign_POM {

	public static void main(String[] args) throws IOException {
		WebDriverUtility webdriverutility= new WebDriverUtility();
		Excelutility excelutility= new Excelutility();
		FileUtility fileutility= new FileUtility();
		JavaUtility javautility= new JavaUtility();
		WebDriver driver1 = null;
		//CreateCampaignPage createcampaign= new CreateCampaignPage(driver1);
		fileutility.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		String url= fileutility.getDataFromPropertyFile("url");
		String username= fileutility.getDataFromPropertyFile("username");
		String password= fileutility.getDataFromPropertyFile("password");
		String browser= fileutility.getDataFromPropertyFile("browser");
		String timeout = fileutility.getDataFromPropertyFile("timeout");
		long timeouts = (long)javautility.convertToAnyDataType(timeout,DataType.LONG);
		
		WebDriver driver=webdriverutility.OpenBrowserWithApplication(browser, timeouts , url);
		CampaignPage campaignpage= new CampaignPage(driver);
		LoginPage loginpage= new LoginPage(driver);
		CommonPage commonpage= new CommonPage(driver);
		loginpage.loginAction("admin", "admin");
		 Actions action =new Actions(driver);
			WebElement morelink = driver.findElement(By.xpath("//a/img[@style=\"padding-left:5px\"]"));
			action.moveToElement(morelink).build().perform();
		  // commonpage.clickRequiredTab(null, webdriverutility)
		   campaignpage.createCampaign();
		   String camp_name = excelutility.getDataFromExcel(IConstantPath.EXCE_PATH, "CAMPAIGN", 13, 2);
		   System.out.println(camp_name);
		   String target_audience = excelutility.getDataFromExcel(IConstantPath.EXCE_PATH,"CAMPAIGN", 13, 4);
		   CreateCampaignPage createCampaign = new CreateCampaignPage(driver);
		   createCampaign.createCampaignName(camp_name , target_audience);
		  // createcampaign.CreateCampaign(camp_name);
		  // createCampaign.saveinformation();
		   
		   
		   
		
		}

}
