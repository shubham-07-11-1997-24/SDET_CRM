package Practice;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BasicConfigAnnotationPractice {
	@BeforeSuite
	public void suiteSetup() {
		System.out.println("before suit");
		
	}
	@BeforeClass
	public void classSuite() {
		System.out.println("before class");
	}

}
