package sdetProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import common.BaseTest1;

public class FooterText extends BaseTest1{
  @Test
  public void printFooterText() {
	  
	  /*
	   * Print the footer text
	   */
	  WebElement footerElem = getDriver().findElement(By.id("admin_options"));
	  System.out.println("The first footer text is :" + footerElem.getAttribute("innerHTML"));
  }
}
