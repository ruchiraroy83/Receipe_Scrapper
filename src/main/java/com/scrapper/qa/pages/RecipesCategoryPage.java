package com.scrapper.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.scrapper.qa.base.TestBase;
import org.openqa.selenium.support.*;
import org.testng.Reporter;

public class RecipesCategoryPage  extends TestBase {
	@FindBy(xpath="//a[@id='ctl00_cntleftpanel_ttlhealthtree_tvTtlHealtht0']")
	WebElement HeathyRecipesLink;
	@FindBy(css= "#ctl00_cntleftpanel_quicktree_tvQuickt0")
	WebElement RecipeCategorieslink;
	@FindBy(xpath="//a[@id='ctl00_cntleftpanel_kidstree_tvKidCornert0']")
	WebElement KidsCategorieslink;
	@FindBy(css= "#ctl00_cntleftpanel_cattreecuisine_tvCuisinet0")
	WebElement byCuisines;
	public RecipesCategoryPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String clickHealthyRecipe(){
		 try {
			if (HeathyRecipesLink.isEnabled()) {
				String CatName=HeathyRecipesLink.getText();
				 HeathyRecipesLink.click();
				 String[] Result=CatName.split(" ");
				 String CategoryName=Result[0] + " " +Result[1];
				 return CategoryName;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Healthy Receipes Link is not found");
		}
		return null;
		
	}
	public String clickQuickRecipe(){
		 try {
			if (RecipeCategorieslink.isEnabled()) {
				String CatName=RecipeCategorieslink.getText();
				RecipeCategorieslink.click();
				 String[] Result=CatName.split(" ");
				 String CategoryName=Result[0] + " " +Result[1];
				 return CategoryName;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Quick Receipes Link is not found");
		}
		return null;
		
	}
	
	public String clickKidsRecipe(){
		 try {
			if (KidsCategorieslink.isEnabled()) {
				String CatName=KidsCategorieslink.getText();
				KidsCategorieslink.click();
				 String[] Result=CatName.split(" ");
				 String CategoryName=Result[0] + " " +Result[1];
				 return CategoryName;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Kids Receipes Link is not found");
		}
		return null;
		
	}
	
	public String ClickCuisinelink() {
		 
		try {
			if(byCuisines.isEnabled()) {
				byCuisines.click();
				String cat=driver.getTitle();
				String[] catarray=cat.split(":");
				System.out.println(" Category name"+catarray[0]);
				return catarray[0];
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Reporter.log("Cuisine Receipes Link is not found");
		}
		return null;
	}



}
