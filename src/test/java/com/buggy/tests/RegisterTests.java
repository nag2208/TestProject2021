package com.buggy.tests;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buggy.framework.BaseTest;
import com.buggy.helper.CsvReader;
import com.buggy.models.User;
import com.buggy.pages.RegisterPage;

public class RegisterTests extends BaseTest {

	@Test(description = "user registration test", dataProvider = "UserRegistrationTestData")
	public void UserRegistrationTest(User user, String status) {
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.RegisterBuggyCarRating(user);
		registerPage.ValidateRegistraion(status);
	}

	@DataProvider(name = "UserRegistrationTestData")
	public Object[][] UserRegistrationTD() {
		return new Object[][] { { new User("Test1", "test2", "Passsss@1212", "Passsss@1212"), "valid" },
				{ new User("Test2", "test3", "passsss@1212", "passsss@1212"), "invalid" } };
	}

//User Registration test data test example using csv file 
	@Test(description = "csv data for registration", dataProvider = "RegistrationData")
	public void RegistrationTest(String Login, String FirstName, String LastName, String Password,
			String ConfirmPassword, String Status) throws Exception {
		RegisterPage registerPage = new RegisterPage(driver);
		//
		if (Login.length() == 0) Login = "   ";
		registerPage.RegisterBuggyCarRating(Login, FirstName, LastName, Password, ConfirmPassword);
		registerPage.ValidateRegistraion(Status);
	}

	@DataProvider(name = "RegistrationData")
	public Iterator<Object[]> RegistrationTD() throws IOException {
		String path = Paths.get("").toAbsolutePath().toString()
				+ "\\src\\test\\resources\\data\\UserRegistrationData.csv";
		return CsvReader.parseCsvData(path);
	}
}
