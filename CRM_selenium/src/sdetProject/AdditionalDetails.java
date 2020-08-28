package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import common.BaseTest2;

public class AdditionalDetails extends BaseTest2 {
	@Test
	public void printDetail() {


		WebElement accounts = getDriver().findElement(By.xpath("//*[text()='Leads']"));
		getDriver().get(accounts.getAttribute("href"));
		WebElement iconElem = getWaiter().until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[starts-with(@onclick,'lvg_')]")));
		iconElem.click();
		WebElement mobile = getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='phone']")));
		System.out.println("The mobile number is " + mobile.getText());
		
	}
}
