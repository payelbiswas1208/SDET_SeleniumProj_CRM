package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.BaseTest1;

public class ImageUrl extends BaseTest1 {
	@Test
	public void printImageUrl() {

		/*
		 * Print the Image source to the console
		 */
		WebElement headerImg = getDriver().findElement(By.linkText("SuiteCRM"));
		String imageUrl = headerImg.getAttribute("href");
		System.out.println("The Image URL text is " + imageUrl);

	}
}
