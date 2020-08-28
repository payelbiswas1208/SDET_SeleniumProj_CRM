package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest2;

public class TraverseTable1 extends BaseTest2 {
	@Test
	public void printNames() {

		WebElement accounts = getDriver().findElement(By.xpath("//a[text()='Accounts']"));
		getDriver().get(accounts.getAttribute("href"));
		WebElement accTable = getWaiter().until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='list view table-responsive']")));

		Assert.assertTrue(accTable.isDisplayed(), "Assert table is present");

		System.out.format("+----------+%n");
		System.out.format("| Names   |%n");
		System.out.format("+----------+%n");

		for (int i = 1; i < 10; i++) {
			if (i % 2 != 0) {
				String xFinder = String.format("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[%d]/td[3]/b/a", i);
				WebElement rowNameData = getDriver().findElement(By.xpath(xFinder));
				System.out.println(rowNameData.getText());
			}
		}

	}
}
