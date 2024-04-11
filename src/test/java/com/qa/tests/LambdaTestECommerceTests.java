package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.basetests.DriverBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PageWaitHelper;

public class LambdaTestECommerceTests extends DriverBase {
	private WebDriver driver;
	private PageWaitHelper pageWaitHelper = new PageWaitHelper();

	@Test
	public void testLoadHomePage() {
		this.driver = getDriver();
		driver.manage().window().maximize();
		driver.get(config.getProperty("url"));
		pageWaitHelper.pageImplicitlyWait(driver);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, config.getProperty("homepageTitle"));
	}

	@Test
	public void testAccountLogin() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginButton();
		pageWaitHelper.pageImplicitlyWait(driver);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, config.getProperty("accountLoginPageTitle"));
	}
	
	@Test
	public void testLoginProcess() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(config.getProperty("username"), config.getProperty("password"));
		pageWaitHelper.pageImplicitlyWait(driver);
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, config.getProperty("loginPageTitle"));
	}
}
