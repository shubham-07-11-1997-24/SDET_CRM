package CRM_sdet40_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	//decalration
	
	@FindBy(xpath = "//td[@id='mouseArea_Campaign Name']") public WebElement actualCamapignNameText;
	
	//initialization
	
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	 //business library
	
	 public String getCampaignNameText() {
		return actualCamapignNameText.getText();
		
		 
	 }

}
