package CRM_sdet40_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	@FindBy(name = "campaignname") private WebElement CampaignName;
//	@FindBy(xpath = "//input[@name='campaignname']") private WebElement CampaignName;
	@FindBy(name = "targetaudience") private WebElement TargetAudience;
	@FindBy(xpath = "//input[@class='crmButton small save']") WebElement SaveButton;
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void createCampaignName(String campaignname, String targetaudience) {
		CampaignName.sendKeys(campaignname);
		TargetAudience.sendKeys(targetaudience);
	}
	public void saveinformation() {
		SaveButton.click();
	}

}
