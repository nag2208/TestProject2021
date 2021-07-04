package com.buggy.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buggy.framework.BaseTest;
import com.buggy.models.User;
import com.buggy.pages.LoginPage;
import com.buggy.pages.ProfilePage;

public class ProfileTests extends BaseTest {

	@Test(description = "Profile Test", dataProvider = "ProfileTestData")
	public void UserProfileTest(User user, String status) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginBuggyCarRating(username, password);
		ProfilePage profilePage = new ProfilePage(driver);
		profilePage.VerifyProfilePageBuggy(user);
		profilePage.ValidateProfileUpdate(status);
		loginPage.ClickLogout();
	}

	@DataProvider(name = "ProfileTestData")
	public Object[][] provideData() {
		return new Object[][] { { new User("test1", "user1", "Male", "25", "21 Test Street", "0123456"), "valid" },
				{ new User("test2", "user1", "Male", "ABC", "22 Test Street", "01234567"), "invalid" } };
	}
}
