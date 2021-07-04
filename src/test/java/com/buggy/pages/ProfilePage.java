package com.buggy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.buggy.models.User;

public class ProfilePage

{
	WebDriver driver;

	public ProfilePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Profile']")
	WebElement profileButton;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "gender")
	WebElement gender;

	@FindBy(id = "age")
	WebElement age;

	@FindBy(id = "address")
	WebElement address;

	@FindBy(id = "phone")
	WebElement phone;

	@FindBy(id = "hobby")
	WebElement hobby;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[normalize-space()='The profile has been saved successful']")
	WebElement profileAlert;
	
	@FindBy(xpath = "//*[normalize-space()='Unknown error']")
	WebElement errorAlert;

	public void ValidateProfileUpdate(String status) {
		if (status.equals("valid")) {

			String actualValue = profileAlert.getText();
			String expectedValue = "The profile has been saved successful";

			Assert.assertEquals(actualValue, expectedValue, "Profile should be saved successful");
		} else if (status.equals("invalid")) {
			
			String actualValue = errorAlert.getText();
			String expectedValue = "Unknown error";

			Assert.assertEquals(actualValue, expectedValue, "Unknown error should display");

		}
	}

	public void VerifyProfilePageBuggy(User user) {
		profileButton.click();
		ClearAndSendText(firstName, user.getFirstName());
		ClearAndSendText(lastName, user.getLastName());
		ClearAndSendText(gender, user.getGender());
		ClearAndSendText(age, user.getAge());
		ClearAndSendText(address, user.getAddress());
		ClearAndSendText(phone, user.getPhone());
		Select selectHoby = new Select(hobby);
		selectHoby.selectByVisibleText("Learning");
		saveButton.click();
	}

	public void ClearAndSendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

}
