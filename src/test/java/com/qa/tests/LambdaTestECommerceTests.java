package com.qa.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.qa.basetests.DriverBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.PageWaitHelper;

public class LambdatestECommerceTests extends DriverBase {
	private WebDriver driver;
	private PageWaitHelper pageWaitHelper = new PageWaitHelper();
	private ExtentReports extent;
	private ExtentTest test;

	@BeforeClass
	public void setUpExtentReports() {
		ExtentSparkReporter spark = new ExtentSparkReporter("target/reports/Spark.html");
		extent = new ExtentReports();
		extent.attachReporter(spark);
	}

	@Test
	public void testLoadHomePage() throws IOException {
		this.driver = getDriver();
		driver.manage().window().maximize();
		driver.get(config.getProperty("url"));
		test = extent.createTest("Validate Home Page", "This test validates whether Home page is loaded or not");
		pageWaitHelper.pageImplicitlyWait(driver);
		String actualTitle = driver.getTitle();
		AssertionHelper.assertAndReport(test, actualTitle, config.getProperty("homepageTitle"), "testLoadHomePage",
				driver);
	}

	@Test
	public void testAccountLogin() throws IOException {
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginButton();
		pageWaitHelper.pageImplicitlyWait(driver);
		String actualTitle = driver.getTitle();
		test = extent.createTest("Validate Login Page", "This test validates whether Login page is loaded or not");
		AssertionHelper.assertAndReport(test, actualTitle, config.getProperty("accountLoginPageTitle"),
				"testAccountLogin", driver);
	}

	@Test
	public void testLoginProcess() throws IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(config.getProperty("username"), config.getProperty("password"));
		pageWaitHelper.pageImplicitlyWait(driver);
		String actualTitle = driver.getTitle();
		test = extent.createTest("Validate Login Process",
				"This test validates whether user can able to Login with valid credentials");
		AssertionHelper.assertAndReport(test, actualTitle, config.getProperty("loginPageTitle"), "testLoginProcess",
				driver);
	}

	@AfterClass
	public void tearDownExtentReports() {
		extent.flush();
	}
}
