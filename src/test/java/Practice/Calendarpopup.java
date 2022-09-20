package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendarpopup {

	public static void main(String[] args) {
		String actualMonthyear = null; 
		String actualyear = null ; 
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String requireddate = "20";
		String requiredmonth= "jan";
		String requiredyear= "2023";
		
		
		
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.findElement(By.id("datepicker")).click();
		String data= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		//System.out.println(date);
		
		String[] str= split("  ");
		String actualMonth=str[0];
		String actualyear1=str[1];
		while(!(actualMonth.equals(requiredmonth) && actualyear1.equals(requiredyear))) {
			driver.findElement(By.xpath("/span[text()='next']")).click();
			 actualMonth = driver.findElement(By.xpath("//div[@class= 'ui-datepicker-title']")).getText();
			str= actualMonth.split(" ");
			actualMonth=str[0];
			actualyear1=str[1];
			
		}
		driver.findElement(By.xpath("//a[text()='"+requireddate+"']")).click();
	}

	private static String[] split(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
