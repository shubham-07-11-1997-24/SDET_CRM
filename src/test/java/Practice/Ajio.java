package Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ajio {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./src/test/resources/testdata.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sheet= wb.getSheet("ajio");
		String productname=sheet.getRow(1).getCell(0).getStringCellValue();
		
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver= new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.ajio.com/");
		driver.findElement(By.xpath("//a[text()='KIDS']")).click();
		driver.findElement(By.xpath("//a[@href='/s/0-to-2-years-3767-54091']")).click();
		//String productname = "Graphic Print Hooded T-shirt"; 
		driver.findElement(By.xpath("//div[text()='"+productname+"']"));
		String productprice = driver.findElement(By.xpath("//div[text()='"+productname+"']/following-sibling::div/span[@class='price  ']")).getText();
	    System.out.println(productprice);
	    sheet.getRow(1).createCell(1).setCellValue(productprice);
	    FileOutputStream fos= new FileOutputStream("./src/test/resources/testdata.xlsx");
	    wb.write(fos);
	    driver.findElement(By.xpath("//div[text()='"+productname+"']")).click();
		
		
		
		

	}

}
