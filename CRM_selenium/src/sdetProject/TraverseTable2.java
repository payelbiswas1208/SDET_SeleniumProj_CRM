package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import common.BaseTest2;

public class TraverseTable2 extends BaseTest2 {
	@Test
	public void printNameUsername() {

		WebElement accounts = getDriver().findElement(By.xpath("//a[text()='Leads']"));
		getDriver().get(accounts.getAttribute("href"));
		WebElement accTable = getWaiter().until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='list view table-responsive']")));

		Assert.assertTrue(accTable.isDisplayed(), "Assert table is present");

		System.out.format("+----------+%n");
		System.out.format("| Names   |%n");
		System.out.format("+----------+%n");

		for (int i = 1; i < 11; i++) {

			String xFinder = String.format("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[%d]/td[3]/b/a", i);
			WebElement rowNameData = getDriver().findElement(By.xpath(xFinder));
			System.out.println(rowNameData.getText());

		}

		System.out.format("+--------------+%n");
		System.out.format("| UserNames   |%n");
		System.out.format("+--------------+%n");

		for (int j = 1; j < 11; j++) {

			String xPathFinder = String.format("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[%d]/td[8]/a", j);
			WebElement userNameData = getDriver().findElement(By.xpath(xPathFinder));
			System.out.println(userNameData.getText());

		}
	}
}
