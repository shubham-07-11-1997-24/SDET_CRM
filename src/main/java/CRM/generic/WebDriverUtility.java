package CRM.generic;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class consist all the wedriver browser
 * 
 * @author BHARDWAJ
 *
 */

public class WebDriverUtility {
	
	private static final String classNmae = null;
	private byte[] actualcampname;
	private byte[] expectedcampname;
	private String expectedText;
	private Object waitTillElementVisible;
	private WebDriver driver;
	
	public WebDriver launchBrowser(String browser) {
		
		switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("invalid broswer name");
			break;
		}

		return driver;
	}

	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void verifyWebPage(WebElement element, WebDriver driver, long longTimeout,String expectedResult) {
		for(;;){
			try {
			Assert.assertEquals(element.getText(), expectedText);
			break;
			}
			catch(Exception e) {
				waitTillElement(driver, longTimeout, element);
		}
	}
	}

	@SuppressWarnings("deprecation")
	public void waitPageTillGetLoad(WebDriver driver, Long longtimeout) {
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
	}

	public void navigateapplication(WebDriver driver, String url) {
		driver.get(url);
	}

	public WebDriver OpenBrowserWithApplication(String broswer, long timeout, String url) {
		WebDriver driver = launchBrowser(broswer);
		maximizeBrowser(driver);
		waitPageTillGetLoad(driver, timeout);
		navigateapplication(driver, url);
		return driver;
	}

	public void mouseHoverAction(WebDriver driver, WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		new Actions(driver).doubleClick().perform();
	}

	public void closeBroswer(WebDriver driver) {
		driver.quit();
	}

	public void waitTillElement(WebDriver driver, long longTime, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTime));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void switchWindow(WebDriver driver) {
		Set<String> windowsId = driver.getWindowHandles();
		for (String string : windowsId) {
			driver.switchTo().window(string);
			if (string.contains("Accounts"))
				break;
		}
		 
			
			
		}
	public void verifyResult(String campaignName, String Targetaudience) {
		Assert.assertEquals(actualcampname, expectedcampname);
		
	}
	public void verifyResult(boolean condition) {
		Assert.assertTrue(condition);
}

	
	private JavascriptExecutor jsExecutor;
	public void jsIntiallization(WebDriver driver) {
		  jsExecutor = (JavascriptExecutor)driver;
		
	}
	public void openApplicationJS(String url) {
		jsExecutor.executeScript("window.location=arguments[0]", url);
	}
	public void sendkeysUsingJS(WebElement element, String data) {
		jsExecutor.executeScript("arguments[0].value=arguments[1]", element,data);
		
	}
	public void clickUsingJS(WebElement element) {
		jsExecutor.executeScript("arguments[0].click()", element);
			
		}
	public void scrollTitleElementusingJS(WebElement element) {
		jsExecutor.executeScript("arguments[0].value=arguments[1]", element);
	}
	public void screenShot(WebDriver driver,JavaUtility javaUtility,String classNmae) throws IOException {
		String currentTime= javaUtility.CurrentTime();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		File dst= new File("./screenshot/"+classNmae+"_"+currentTime+".png");
		FileUtils.copyFile(src, dst);
		
		
		
	}
	
	public WebElement convertDynamicXpathIntoWebElement(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath= String.format(dynamicXpath, replaceData);
		WebElement element= driver.findElement(By.xpath(requiredXpath));
		return element;
	}
	public By convertDynamicXpathIntoByClass(String dynamicXpath, String replaceData, WebDriver driver) {
		String requiredXpath= String.format(dynamicXpath, replaceData);
		By element= By.xpath(requiredXpath);
		return element;
		
	}
		
	}
	

