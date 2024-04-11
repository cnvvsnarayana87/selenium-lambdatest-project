package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class PageWaitHelper {

	public void pageImplicitlyWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
