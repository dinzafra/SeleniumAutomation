package testCases;
import org.testng.annotations.Test;

import common.BaseTest;


public class SampleTestCase extends BaseTest {

	@Test(priority =1)
	public void clearPasswordCreds() throws InterruptedException {

		demoTest.clearPassword();
	}
}