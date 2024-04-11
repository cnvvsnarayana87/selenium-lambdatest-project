package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	private By usernameLocator = By.xpath("//input[@id=\"input-email\"]");
	private By passwordLocator = By.xpath("//input[@id=\"input-password\"]");
	private By loginBtnLocator = By.xpath("//input[@type=\"submit\"]");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getUsernameElement() {
		return driver.findElement(usernameLocator);
	}

	public WebElement getPasswordElement() {
		return driver.findElement(passwordLocator);
	}

	public WebElement getLoginBtnElement() {
		return driver.findElement(loginBtnLocator);
	}

	public void performLogin(String userName, String passWord) {
		getUsernameElement().sendKeys(userName);
		getPasswordElement().sendKeys(passWord);
		getLoginBtnElement().click();
	}
}
