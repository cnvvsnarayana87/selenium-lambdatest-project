package com.qa.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

public class AssertionHelper {
	public static void assertAndReport(ExtentTest test, String actualValue, String expectedValue, String testName,
			WebDriver driver) throws IOException {
		if (actualValue.equals(expectedValue)) {
			test.pass(testName + " completed successfully");
		} else {
			test.fail(testName + " failed.");
			test.fail(MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot(driver)).build());
		}
		Assert.assertEquals(actualValue, expectedValue);
	}

	public static String captureScreenshot(WebDriver driver) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				System.getProperty("user.dir") + "\\target\\screenshots\\" + System.currentTimeMillis() + ".png");
		String errFilePath = destFile.getAbsolutePath();
		FileUtils.copyFile(srcFile, destFile);
		return errFilePath;
	}
}