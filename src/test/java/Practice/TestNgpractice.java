package Practice;

import org.testng.annotations.Test;

public class TestNgpractice {

	@Test(dependsOnMethods= "Step2Test", alwaysRun= true)
	public void suiteSetup() {
		System.out.println("Beforesuit");

	}
}
