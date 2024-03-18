package testCases;

import org.testng.annotations.Test;

import common.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

//import static org.assertj.core.api.Assertions.assertThat;

public class DemoTest extends BaseTest {

	@Test(priority = 1, description = "Login")
	public void enterCredentials() {

		demoTest.enterUserName(data.getUserName());
		demoTest.enterPassword(data.getPassword());

	}

	@Test(priority = 2, description = "Click Login BUtton")
	public void clickLogin() {

		demoTest.clickLoginButton();
	}

	@Test(priority = 3)
	public void clearCredentials() throws InterruptedException {
		demoTest.clearUserName();
	}

	public void enterText(String id, String input) {
		WebElement element = driver.findElement(By.id(id));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
		element.sendKeys(input);
	}

	public void clearText(String id) {
		WebElement element = driver.findElement(By.id(id));
		element.clear();
	}

	public void clearUserName() throws InterruptedException {
		clearText("user-name");
		Thread.sleep(500);
	}

	public void clearPassword() throws InterruptedException {
		clearText("passwords");
		Thread.sleep(500);

	}

	public void enterUserName(String userName) {
		enterText("user-name", userName);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	}

	public void enterPassword(String password) {
		enterText("password", password);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	}

	public void clickLoginButton() {
		 WebElement loginButton = driver.findElement(Locator.loginButton);
	//	WebElement loginButton = driver.findElement(By.id("login-buttons"));
		loginButton.click();
	}

}
