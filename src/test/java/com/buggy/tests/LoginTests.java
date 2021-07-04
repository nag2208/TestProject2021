package com.buggy.tests;

import org.testng.annotations.Test;

import com.buggy.framework.BaseTest;
import com.buggy.pages.LoginPage;

public class LoginTests extends BaseTest

{
	@Test
	public void UserLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginBuggyCarRating(username, password);
		loginPage.ValidateLogin();
	}

	@Test
	public void UserLogoutTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginBuggyCarRating(username, password);
		loginPage.ClickLogout();
		loginPage.ValidateLogout();

	}

}
