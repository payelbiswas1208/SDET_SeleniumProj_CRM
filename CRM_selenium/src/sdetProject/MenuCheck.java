package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest2;

public class MenuCheck extends BaseTest2 {
	@Test
  public void verifyMenu() {
	  
	  WebElement menu = getWaiter()
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Activities']")));
	  Assert.assertTrue(menu.isDisplayed(), "Assert Activities menu is present");
  }
}
