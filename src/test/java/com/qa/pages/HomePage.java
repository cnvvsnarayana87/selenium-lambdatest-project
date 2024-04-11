package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	private WebDriver driver;
	private By myAccountLocator = By.xpath("//header//span[contains(text(),\" My account\")]");
	private By loginBtnLocator = By.xpath("//header//span[contains(text(),\" Login\")]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getMyAccountElement() {
		return driver.findElement(myAccountLocator);
	}

	public WebElement getLoginButtonElement() {
		return driver.findElement(loginBtnLocator);
	}

	public void clickOnLoginButton() {
		Actions actions = new Actions(driver);
		actions.moveToElement(getMyAccountElement()).perform();
		getLoginButtonElement().click();
	}
}
