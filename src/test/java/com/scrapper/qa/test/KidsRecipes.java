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

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class KidsRecipes extends TestBase{
	HomePage homePage;
	RecipesCategoryPage recipeCatPage;
	RecipesListPage recipesListPage;
	RecipeDetailsPage recipesDetailsPage;
	
	public KidsRecipes() {
		super();
	}	
  @Test
  public void ScrapeKidsReceipe() throws IOException {
	homePage.ClickRecipes();
	String Category=recipeCatPage.clickKidsRecipe();
	recipesListPage.ClickOnRecipe_GetDetails(Category,1);
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
  public void afterTest() {
	  driver.close();
	  driver.quit();
  }

}
