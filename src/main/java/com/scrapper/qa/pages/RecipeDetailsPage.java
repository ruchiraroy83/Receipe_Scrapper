package com.scrapper.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.scrapper.qa.base.TestBase;

public class RecipeDetailsPage extends TestBase {
//	PageFactory -Object repository
	@FindBy(xpath = "//div[@id='rcpinglist']")
	WebElement ingredients;
	@FindBy(xpath = "//div[@id='ctl00_cntrightpanel_pnlRcpMethod']")
	WebElement CookingMethod;
	@FindBy(xpath = "//div[@id='accompaniments']")
	WebElement nutrients;
	@FindBy(xpath = "//img[@id='ctl00_cntrightpanel_imgRecipe']")
	WebElement img_link;

	public RecipeDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	public String GetTitle() {
		return driver.getTitle();

	}

	public String GetRecipeURL() {
		return driver.getCurrentUrl();

	}

	public String GetIngredients() {
		try {
			if (ingredients.isDisplayed()) {
				return ingredients.getText();
			}
		} catch (Exception e) {
			Reporter.log("Ingredients Not Found");
			return null;
		}
		return null;

	}

	public String GetCookingSteps() {
		try {
			if (CookingMethod.isDisplayed()) {
				return CookingMethod.getText();
			}
		} catch (Exception e) {
//			e.printStackTrace();
			Reporter.log("Cooking Method Not Found");
		}
		return null;

	}

	public String GetNutrients() {
		try {
			if (nutrients.isDisplayed()) {
				String Nut=nutrients.getText();
				String Nutrients;
				if (Nut.indexOf("Click")==0) {
					Nutrients=Nut.substring(Nut.indexOf("Nutrient"));
				}else {
					Nutrients=Nut.substring(Nut.indexOf("Nutrient"), Nut.indexOf("Click"));
				}
				
				return Nutrients;
			}
		} catch (Exception e) {
			Reporter.log("No Nutrients Data is present");
			return null;
		}
		return null;

	}

	public String Getimg_link() {
		try {
			if (img_link.isEnabled()) {
				return img_link.getAttribute("src");
			}
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
		return img_link.getText();
	}
}
