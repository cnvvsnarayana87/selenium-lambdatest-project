package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogoutPage {
	private WebDriver driver;

	private By logoutBtnLocator = By.xpath("//aside//a[contains(text(),\" Logout\")]");

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogoutBtnElement() {
		return driver.findElement(logoutBtnLocator);
	}

	public void performLogout() {
		getLogoutBtnElement().click();
	}
}
