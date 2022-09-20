package Practice.testNg;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertionpPactice {
	//@Test
	//public void test1() {
		//String  actual="hiii";
		//String expected="hiiihello";
		//Assert.assertTrue(actual.equalsIgnoreCase(expected));
		
	//}
	@Test
	public void test1() {
		SoftAssert soft= new SoftAssert();
		String  actual="hiii";
		String expected="hiiihello";
		Reporter.log("test1",true);
		Assert.assertEquals(actual, expected);
		Reporter.log(expected);
		
	}
	@Test
	public void test2() {
		Reporter.log("test2",true);
	}

}
