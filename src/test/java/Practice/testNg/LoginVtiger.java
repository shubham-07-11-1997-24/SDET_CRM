package Practice.testNg;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import CRM.generic.BaseClass;
import CRM.generic.IConstantPath;
import CRM_sdet40_objectRepository.CampaignInformationPage;
import CRM_sdet40_objectRepository.CampaignPage;
import CRM_sdet40_objectRepository.CreateCampaignPage;
import CRM_sdet40_objectRepository.TabName;

public class LoginVtiger extends BaseClass {
	@Test
	public void createCampaignTest(Method mtd) throws Throwable, IOException {

		String CampName = excelUtility.getDataFromExcel("Camp_module", "campaign name", mtd.getName()) + randomNumber;
		String targetAudience = excelUtility.getDataFromExcel("Camp_module","Target audience", mtd.getName());

		System.out.println(CampName);
		commonPage.clickRequiredTab(TabName.Campaign, webdriverUtility);
		CampaignPage campaignPage = new CampaignPage(driver);
		campaignPage.createCampaign();
		CreateCampaignPage createCampaignPage = new CreateCampaignPage(driver);
		createCampaignPage.createCampaignName(CampName, targetAudience);
		CampaignInformationPage campaignInforPage = new CampaignInformationPage(driver);
		webdriverUtility.waitTillElement(driver, longTimeout, campaignInforPage.actualCamapignNameText);
		commonPage.clickRequiredTab(TabName.Campaign, webdriverUtility);
		commonPage.clickOtherMajorTabs(webdriverUtility);
		if (campaignPage.getListOfCampaignName(CampName))
			System.out.println("cmpage created");
		else
			System.out.println("cmpage is not created");

	}
}

