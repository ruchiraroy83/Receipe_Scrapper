package com.scrapper.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import com.scrapper.qa.base.TestBase;
import org.openqa.selenium.support.*;
import org.testng.Reporter;

public class HomePage extends TestBase {
	
	//PageFactory -OR
	@FindBy(xpath="//div[contains(text(),'RECIPES')]")
	WebElement Recipes;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public RecipesCategoryPage ClickRecipes() {
		try {
			if(Recipes.isDisplayed()) {
				Recipes.click();
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				return new RecipesCategoryPage();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Recipes button is not displayed");
			return null;
		}
		return new RecipesCategoryPage();
	}
}
