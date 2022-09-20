package CRM_sdet40_objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CRM.generic.WebDriverUtility;

public class CommonPage {
	private WebDriver driver;
	private CommonPage common;

	//declaration
	private String dynamicXpath="//a[.='%s']";
	@FindBy(xpath = "//a[@href='index.php?module=Campaigns&action=index']")private WebElement campaignTab;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement Administration;

	@FindBy(xpath="//a[text()='More']")
	private WebElement moreDropDown;
	
	@FindBy(xpath="//a[@href='index.php?module=Campaigns&action=index']")
	private WebElement campaignMajorTab;
	
	//@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']") WebElement signoutLink;

	//Initiallization all variable


	public CommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//business library
	/**
	 * @param <TabNames>
	 * @param tableName
	 * @paramwebDriverUtility
	 */

	public  void clickRequiredTab(TabName tabname, WebDriverUtility webDriverUtility) {
		webDriverUtility.convertDynamicXpathIntoWebElement(dynamicXpath, tabname.toString(), driver).click();

	}

	public void signoutAction(WebDriverUtility webDriverutility, WebDriver driver) {
		webDriverutility.mouseHoverAction(driver, Administration);
		webDriverutility.convertDynamicXpathIntoWebElement(dynamicXpath, "sign out", driver).click();
	}
	public void clickOtherMajorTabs(WebDriverUtility webDriverUtility) {
		webDriverUtility.mouseHoverAction(driver, moreDropDown);
		campaignMajorTab.click();
		
	}


}
