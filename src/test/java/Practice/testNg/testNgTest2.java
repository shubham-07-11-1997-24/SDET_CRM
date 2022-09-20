package Practice.testNg;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNgTest2 {

	@Test(dependsOnMethods = "testCase5")
	public void testCase4() {
		System.out.println("test4");
	}
	
	@Test
	public void testCase5() {
		System.out.println("test5");
		Assert.fail();
	}
	
	@Test
	public void testCase6() {
		System.out.println("test6");
	}
}
