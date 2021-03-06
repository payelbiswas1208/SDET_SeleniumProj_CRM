package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest1;
import common.Configuration;

public class CRMLogin extends BaseTest1 {
	@Test
	public void loginAdmin() {

		/*
		 * Enter username and verify text
		 */
		WebElement userTextBox = getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.name("user_name")));
		userTextBox.sendKeys(Configuration.USER_NAME);
		Assert.assertEquals(Configuration.USER_NAME, userTextBox.getAttribute("value"), "Assert the user name text");
		
		/*
		 * Enter password and verify text
		 */
		WebElement pwdTextBox = getDriver().findElement(By.name("username_password"));
		pwdTextBox.sendKeys(Configuration.PASSWORD);
		Assert.assertEquals(Configuration.PASSWORD, pwdTextBox.getAttribute("value"), "Assert the password text");

		/*
		 * Click submit button and verify homepage is displayed
		 */
		WebElement submitButton = getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("bigbutton")));
		submitButton.click();
		getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'SUITECRM DASHBOARD')]")));
		
		/*
		 * Logout
		 */
		WebElement logOut = getDriver().findElement(By.xpath("//*[text()='Logout']"));
		getDriver().get(logOut.getAttribute("href"));
		getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'logged out')]")));

	}
}
