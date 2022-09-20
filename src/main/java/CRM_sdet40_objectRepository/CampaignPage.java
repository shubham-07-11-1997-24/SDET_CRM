package CRM_sdet40_objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	// declaration

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createCampaign;
	@FindBy(xpath = "//a[@title='Campaigns']")
	private List<WebElement> listOfCampaignName;

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createCampaign() {
		createCampaign.click();

	}

	public boolean getListOfCampaignName(String result) {
		for (WebElement webElement : listOfCampaignName) {
			return webElement.toString().equalsIgnoreCase(result);
		}
		return false;
	}

}
