package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest2 {

	private WebDriver driver = null;
	private WebDriverWait wait = null;

	@BeforeClass
	public void launchBrowser() {

		setDriver(Configuration.createChromeDriver());
		wait = new WebDriverWait(getDriver(), 60);
		getDriver().get(Configuration.CRM_URL);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void closeBrowser() {
		getDriver().quit();
	}

	protected WebDriver getDriver() {
		return this.driver;
	}

	private void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	protected WebDriverWait getWaiter() {
		return this.wait;
	}

	@BeforeMethod
	public void loginCRM() {

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
		getWaiter().until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'SUITECRM DASHBOARD')]")));

	}

	@AfterMethod
	public void logoutCRM() {
		/*
		 * Logout
		 */
		WebElement logOut = getDriver().findElement(By.xpath("//*[text()='Logout']"));
		getDriver().get(logOut.getAttribute("href"));
		
	}

}
