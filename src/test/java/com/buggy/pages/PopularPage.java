package com.buggy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PopularPage {

	WebDriver driver;

	public PopularPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src='/img/overall.jpg']")
	WebElement overallRating;

	@FindBy(xpath = "//a[normalize-space()='Votes']")
	WebElement votes;

	@FindBy(xpath = "//a[normalize-space()='Lamborghini']")
	WebElement make;

	@FindBy(xpath = "//a[normalize-space()='Diablo']")
	WebElement model;

	@FindBy(xpath = "//a[normalize-space()='Buggy Rating']")
	WebElement buggyRating;

	@FindBy(xpath = "//img[@title='Diablo']")
	WebElement popularModel;

	@FindBy(xpath = "//h4[normalize-space()='Lamborghini']")
	WebElement popularMake;

	@FindBy(xpath = "//h3[normalize-space()='Diablo']")
	WebElement popular_Model;

	public void VerifyPapularmodelBuggyCarRating() {
		overallRating.click();
		votes.click();
		String getmake = make.getText();
		String getmodel = model.getText();
		buggyRating.click();
		popularModel.click();
		String getpopular_make = popularMake.getText();
		String getpopular_model = popular_Model.getText();

		Assert.assertEquals(getmake, getpopular_make,"make should match");
		Assert.assertEquals(getmodel, getpopular_model,"model should match");

	}

}
