package com.buggy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage

{

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "login")
	WebElement login;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement submitLogin;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logoutButton;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerButton;

	

	public void ValidateLogin() {

		String actualValue = logoutButton.getText();
		String expectedValue = "Logout";

		Assert.assertEquals(actualValue, expectedValue, "Logout button should be displayed");
	}

	public void LoginBuggyCarRating(String uid, String pass) {
		login.sendKeys(uid);
		password.sendKeys(pass);
		submitLogin.click();

	}
	
	public void ValidateLogout() {
		
		String actualValue = registerButton.getText();
		String expectedValue = "Register";

		Assert.assertEquals(actualValue, expectedValue, "Register button should be displayed");
	}

	public void ClickLogout() {
		logoutButton.click();
	}

}
