package vtiger1;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import CRM.generic.Excelutility;
import CRM.generic.FileUtility;
import CRM.generic.IConstantPath;
import CRM.generic.WebDriverUtility;
import CRM_sdet40_objectRepository.CampaignPage;
import CRM_sdet40_objectRepository.CommonPage;
import CRM_sdet40_objectRepository.CreateCampaignPage;
import CRM_sdet40_objectRepository.LoginPage;
import CRM_sdet40_objectRepository.TabName;

public class CampaignModule_LstMap {

	public static void main(String[] args) throws IOException {
		Excelutility excelUtility = new Excelutility();
		FileUtility file = new FileUtility();
		file.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		String username = file.getDataFromPropertyFile("username");
		String password = file.getDataFromPropertyFile("password");
		String browser = file.getDataFromPropertyFile("browser");
		String url = file.getDataFromPropertyFile("url");
		excelUtility.intilaizeExcel(IConstantPath.EXCE_PATH);
		List<Map<String, String>> list = excelUtility.getDataFromExcelInList("CAMPAIGNMODULE");
		String campaignname = excelUtility.getDataFromExcel(IConstantPath.EXCE_PATH, "CAMPAIGNMODULE", 0, 1);
		String targetaudience = excelUtility.getDataFromExcel(IConstantPath.EXCE_PATH, "CAMPAIGNMODULE", 1, 1);
		WebDriverUtility webDriverUtility = new WebDriverUtility();
		WebDriver driver = webDriverUtility.OpenBrowserWithApplication(browser, (long) 10000, url);
		LoginPage loginpage = new LoginPage(driver);
		CampaignPage camppage= new CampaignPage(driver);
		CommonPage commonPage = new CommonPage(driver);
		CreateCampaignPage createcamp= new CreateCampaignPage(driver);
		loginpage.loginAction(username, password);
		commonPage.clickRequiredTab(TabName.Campaign, webDriverUtility);
		camppage.createCampaign();
		
		
		
	}

}
