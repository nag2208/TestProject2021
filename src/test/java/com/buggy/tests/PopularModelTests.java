package com.buggy.tests;

import org.testng.annotations.Test;

import com.buggy.framework.BaseTest;
import com.buggy.pages.PopularPage;

public class PopularModelTests extends BaseTest {
	
	@Test
	public void PopularModelTest()
	{
		PopularPage popularPage = new PopularPage(driver);
		popularPage.VerifyPapularmodelBuggyCarRating();
	}

}
