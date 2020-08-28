package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.BaseTest2;

public class MenuColour extends BaseTest2 {
	@Test
	public void printMenuColour() {

		WebElement divElem = getWaiter()
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='ygddfdiv']")));
		System.out.println("Background Colour is : " + divElem.getCssValue("background-color"));
	}
}
