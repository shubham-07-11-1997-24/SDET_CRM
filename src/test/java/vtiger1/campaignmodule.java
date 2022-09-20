package vtiger1;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class campaignmodule {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver:8888/");
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB);
		driver.findElement(By.name("user_password")).sendKeys("admin",Keys.ENTER);
		Actions action =new Actions(driver);
		WebElement morelink = driver.findElement(By.xpath("//a/img[@style=\"padding-left:5px\"]"));
		action.moveToElement(morelink).build().perform();
		driver.findElement(By.name("Campaigns")).click();
	    driver.findElement(By.xpath("//a/img[@alt=\"Create Campaign...\"]")).click();
	    driver.findElement(By.name("campaignname")).sendKeys("banner advt",Keys.TAB);
	   
	    driver.findElement(By.name("targetaudience")).sendKeys("market people",Keys.TAB);
	    driver.findElement(By.name("sponsor")).sendKeys("rellaince",Keys.TAB);
		WebElement ele2= driver.findElement(By.name("campaignstatus"));
		Select s2 = new Select(ele2);
		s2.selectByIndex(3);
		driver.findElement(By.xpath("//img[@ src='themes/softed/images/select.gif']")).click();
		Set<String> allwi= driver.getWindowHandles();
		String ele3 =driver.getWindowHandle();
		System.out.println(ele3);
		for (String wid : allwi) {
			if (!wid.equalsIgnoreCase(ele3)) {
				driver.switchTo().window(wid);
				driver.findElement(By.xpath("//a[text()='router']")).click();
				break;
			}
			driver.findElement(By.name("closingdate")).sendKeys("22-12-2022",Keys.ENTER);
			
		}  
		
		
	}
}
