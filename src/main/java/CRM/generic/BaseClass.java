package CRM.generic;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import CRM_sdet40_objectRepository.CommonPage;
import CRM_sdet40_objectRepository.LoginPage;

public class BaseClass {

	protected LoginPage loginPage;
	private String username;
	private String password;
	private String url;
	private String  timeouts;
	protected long longTimeout;
	protected CommonPage commonPage;
	protected WebDriver  driver ;
	protected WebDriverUtility webdriverUtility;
	protected Excelutility excelUtility;
	protected FileUtility fileUtility;
	protected JavaUtility javaUtility;
	protected int randomNumber;
	private String browser;
	public static WebDriver sdriver;
	public static JavaUtility sjavautility;


	/**
	 * initialize all utility class
	 * open excel, property file
	 * read the common data
	 * create the instance of browser(launch browser)
	 * maximize , implicitwait
	 * open the application
	 * initialize jsexecutor, action, webDriverwait
	 * create yhe instance of common object repo
	 * @throws IOException
	 * 
	 */

	@BeforeClass
	public void classSetup() throws IOException {
		//create instance of Generic Utility
		excelUtility= new Excelutility();
		FileUtility fileUtility= new FileUtility();
		JavaUtility javaUtility= new JavaUtility();
		sjavautility= javaUtility;
		webdriverUtility= new WebDriverUtility();


		//initialize the property file and excel file
		fileUtility.initializePropertyFile(IConstantPath.PROPERTY_FILE_PATH);
		excelUtility.intilaizeExcel(IConstantPath.EXCE_PATH);

		//fetch data from property file
		browser= fileUtility.getDataFromPropertyFile("browser");
		username= fileUtility.getDataFromPropertyFile("username");
		password= fileUtility.getDataFromPropertyFile("password");
		url= fileUtility.getDataFromPropertyFile("url");
		timeouts= fileUtility.getDataFromPropertyFile("timeouts");
		longTimeout=(long) javaUtility.convertToAnyDataType(timeouts, DataType.LONG);
		randomNumber= javaUtility.getRandomNumber(1000);

		//launching the browser and doing some browser setting
		driver= webdriverUtility.launchBrowser(browser);
		sdriver= driver;
		webdriverUtility.navigateapplication(driver, url);
		webdriverUtility.maximizeBrowser(driver);
		webdriverUtility.waitPageTillGetLoad(driver, longTimeout);
		webdriverUtility.jsIntiallization(driver);
		webdriverUtility.jsIntiallization(driver);

		//create object to common pom repo
		loginPage  = new LoginPage(driver);
		commonPage= new CommonPage(driver);


	}
	//login to application
	/**
	 * whenever we create the testscript class for module and test annotation mothod for testcase
	 * create the instance for browser(openbrowser)
	 * maximize, implicit wait
	 * create the instance foe common object repo(driver)
	 * login to the app 
	 * 
	 */
	@BeforeMethod
	public void methodsetup1() {
		loginPage.loginAction(username, password);

	}
	@AfterMethod
	public void methodTearDown() throws FileNotFoundException, IOException {
		//logout from application
		commonPage.signoutAction(webdriverUtility, driver);

		//save the excel data
		excelUtility.saveDataInToExcel(IConstantPath.EXCE_PATH);
	}

		@AfterClass
		public void classTearDown() throws IOException {
			webdriverUtility.closeBroswer(driver);
			excelUtility.closeExcel();
		}

}
