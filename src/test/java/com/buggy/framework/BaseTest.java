package com.buggy.framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.buggy.helper.BrowserFactory;

public class BaseTest {

	public WebDriver driver;
	public String baseUrl = "https://buggy.justtestit.org/";
	public String username = "Test1519";
	public String password = "Password@1";

	@BeforeMethod
	public void Setup() {
		driver = BrowserFactory.startBrowser("chrome", baseUrl);
	}

	@AfterMethod
	public void CleanUp() {
		try {
		driver.quit();
		}catch(Exception e) {
			System.out.println("Issue closing browser");
		}
	}
}
