package com.qa.tests;

import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class AssertionHelper {
	public static void assertAndReport(ExtentTest test, String actualValue, String expectedValue, String testName) {
		if (actualValue.equals(expectedValue)) {
			test.pass(testName + " completed successfully");
		} else {
			test.fail(testName + " failed.");
		}
		Assert.assertEquals(actualValue, expectedValue);
	}
}
