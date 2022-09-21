package Practice.testNg;

import org.testng.annotations.Test;

import CRM.generic.BaseClass;
import CRM_sdet40_objectRepository.CampaignInformationPage;
import CRM_sdet40_objectRepository.CampaignPage;
import CRM_sdet40_objectRepository.CreateCampaignPage;
import CRM_sdet40_objectRepository.TabName;

public class CreateCampaignTest extends BaseClass {
	@Test
	public void createCampaignTest() {
		//fetch data from excel file
		String expectedcampName= excelUtility.getDataFromExcel("Camp_module", "camp_name", "CreateCampaignTest")+randomNumber;
		String expectedTargetaudience= excelUtility.getDataFromExcel("Camp_module", "Target audience","CreateCampaignTest")+randomNumber;
		System.out.println(expectedcampName);
		System.out.println(expectedTargetaudience);
		CampaignPage campaignPage= new CampaignPage(driver);
		CreateCampaignPage createNewCampaign= new CreateCampaignPage(driver);
		CampaignInformationPage campaignInformation= new CampaignInformationPage(driver);
		commonPage.clickRequiredTab(TabName.Campaign, webdriverUtility);
		campaignPage.createCampaign();
		createNewCampaign.createCampaignName(expectedcampName, expectedTargetaudience);
		String actualcampName= campaignInformation.getCampaignNameText();
		webdriverUtility.verifyResult(actualcampName, expectedcampName);
		webdriverUtility.verifyResult(actualcampName.equals(actualcampName));
		
	}

}
