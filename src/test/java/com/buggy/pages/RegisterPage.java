package com.buggy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.buggy.models.User;

import java.util.Random;

public class RegisterPage

{
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerButton;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "firstName")
	WebElement firstname;

	@FindBy(id = "lastName")
	WebElement lastname;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirmPassword")
	WebElement confirmpassword;

	@FindBy(xpath = "//button[normalize-space()='Register']")
	WebElement submitRegister;

	@FindBy(xpath = "//div[normalize-space()='Registration is successful']")
	WebElement regValidation;

	@FindBy(xpath = "//div[@class='result alert alert-danger']")
	WebElement regAlert;

	@FindBy(xpath = "//div[@class='result alert alert-danger']")
	WebElement userNameEx;

	@FindBy(xpath = "//div[@class='result alert alert-danger']")
	WebElement passwordNotValid;

	@FindBy(xpath = "//div[@class='result alert alert-danger']")
	WebElement noLogin;

	Random objGenerator = new Random();
	int randomNumber = objGenerator.nextInt(1000);

	public void ValidateRegistraion(String status) {
		if (status.equals("valid")) {
			String actualValue = regValidation.getText();
			String expectedValue = "Registration is successful";

			Assert.assertEquals(actualValue, expectedValue, "Registration is successful");
		} else if (status.equals("invalid")) {
			String actualValue = regAlert.getText();
			String expectedValue = "InvalidPasswordException: Password did not conform with policy: Password must have uppercase characters";

			Assert.assertEquals(actualValue, expectedValue, "Validation error should display");
		} else if (status.equals("UsernameExists")) {
			String actualValue = userNameEx.getText();
			String expectedValue = "UsernameExistsException: User already exists";

			Assert.assertEquals(actualValue, expectedValue, "User already exisit error should display");
		} else if (status.equals("PasswordNotValid")) {
			String actualValue = passwordNotValid.getText();
			String expectedValue = "InvalidPasswordException: Password did not conform with policy: Password must have numeric characters";

			Assert.assertEquals(actualValue, expectedValue, "Password not valid");
		} else if (status.equals("NoLogin")) {
			String actualValue = noLogin.getText();
			String expectedValue = "InvalidParameterException: 1 validation error detected: Value at 'username' failed to satisfy constraint: Member must satisfy regular expression pattern: [\\p{L}\\p{M}\\p{S}\\p{N}\\p{P}]+";

			Assert.assertEquals(actualValue, expectedValue, "Login name required for registration");
		}
	}

	public void RegisterBuggyCarRating(User user) {
		registerButton.click();
		username.sendKeys(user.getRandomUserName());
		firstname.sendKeys(user.getFirstName());
		lastname.sendKeys(user.getLastName());
		password.sendKeys(user.getPassword());
		confirmpassword.sendKeys(user.getConfirmPassword());
		submitRegister.click();
	}

	public void RegisterBuggyCarRating(String login, String fname, String lname, String pass, String confirmpass) {

		registerButton.click();
		username.sendKeys(login);
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		password.sendKeys(pass);
		confirmpassword.sendKeys(confirmpass);
		submitRegister.click();

	}

}
