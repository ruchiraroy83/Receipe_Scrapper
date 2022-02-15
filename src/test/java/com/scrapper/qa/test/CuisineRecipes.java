package com.scrapper.qa.test;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.scrapper.qa.base.TestBase;
import com.scrapper.qa.pages.HomePage;
import com.scrapper.qa.pages.RecipeDetailsPage;
import com.scrapper.qa.pages.RecipesCategoryPage;
import com.scrapper.qa.pages.RecipesListPage;

public class CuisineRecipes extends TestBase {
	HomePage homePage;
	RecipesCategoryPage recipeCatPage;
	RecipesListPage recipesListPage;
	RecipeDetailsPage recipesDetailsPage;
	
	public CuisineRecipes() {
		super();
	}	

	@Test(priority=1)
	public void ScrapeCuisineReceipes() throws IOException {
		homePage.ClickRecipes();
		String Category=recipeCatPage.ClickCuisinelink();
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
	  driver.close();
	  driver.quit();
	}



}
