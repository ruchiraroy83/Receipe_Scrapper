package com.scrapper.qa.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.scrapper.qa.base.TestBase;
import com.scrapper.qa.pages.HomePage;
import com.scrapper.qa.pages.RecipeDetailsPage;
import com.scrapper.qa.pages.RecipesCategoryPage;
import com.scrapper.qa.pages.RecipesListPage;

public class HealthyReceipes extends TestBase {
	HomePage homePage;
	RecipesCategoryPage recipeCatPage;
	RecipesListPage recipesListPage;
	RecipeDetailsPage recipesDetailsPage;

	public HealthyReceipes() {
		super();
	}	

	@Test
	public void ScrapeHealthyReceipes() {
		homePage.ClickRecipes();
		String Category=recipeCatPage.clickHealthyRecipe();
		recipesListPage.ClickOnRecipe_GetDetails(Category);
	}

	@BeforeTest
	public void beforeTest() {
		initialization();
		homePage = new HomePage();
		recipeCatPage = new RecipesCategoryPage();
		recipesListPage = new RecipesListPage();
		recipesDetailsPage = new RecipeDetailsPage();
	}

	@AfterTest
	public void TearDown() {
//	  driver.close();
//	  driver.quit();
	}

}
