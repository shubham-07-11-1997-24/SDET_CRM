package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMytrip {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[text()='From']")).click();
		driver.findElement(By.xpath("//p[text()='New Delhi, India']/ancestor::ul[@class='react-autosuggest__suggestions-list']/descendant::p[text()='New Delhi, India']")).click();
		driver.findElement(By.xpath("//p[text()='Mumbai, India']/ancestor::ul[@class='react-autosuggest__suggestions-list']/descendant::p[text()='Mumbai, India']")).click();

		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		
		
		
		
		
		
		
	}

}
