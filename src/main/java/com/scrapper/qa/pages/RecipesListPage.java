package com.scrapper.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.scrapper.qa.base.TestBase;
import org.openqa.selenium.support.*;
import org.testng.Reporter;

public class RecipesListPage extends TestBase  {
//	RecipesCategoryPage recCategory=new RecipesCategoryPage();
	
	@FindBy(xpath="//a[@class='respglink']")
	List<WebElement> PageNo;
	@FindBy(xpath="//span[@class='rcc_recipename']")
	List<WebElement> ReceipeNameLink;
	RecipeDetailsPage recipesDetailsPage;
	public RecipesListPage() {
		PageFactory.initElements(driver, this);
	}
	RecipeDetailsPage ReceipeDetails=new RecipeDetailsPage();
	public RecipeDetailsPage ClickOnRecipe_GetDetails(String Category) {
		  try {
			  List<WebElement> PageNum=PageNo;
    		  int totalPages=PageNum.size();
    		  
    		  System.out.println("Total No of pages="+totalPages);
    		  for (int j=0;j<totalPages;j++) {
    			  if (j>0) {
    				  PageNum=PageNo; 
    				  totalPages=PageNum.size();
    				  PageNo.get(j).click();
    				  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    			  System.out.println("Page No " +j);

    			  }
    			  
    			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				List<WebElement> obj_receipeLinks=ReceipeNameLink;
				  int totalLinksperPage = obj_receipeLinks.size();
				  for(int i=0;i<totalLinksperPage;i++){
					  System.out.println("Receipe no :"+i);
					  obj_receipeLinks=ReceipeNameLink;
					  totalLinksperPage=obj_receipeLinks.size();
					  obj_receipeLinks.get(i).click();
					  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//					  String Category=recCategory.RetriveHealthyRecipeCategory();
				      String title=ReceipeDetails.GetTitle();
				      String ReceipeLink=ReceipeDetails.GetRecipeURL();
				      String Ingredients=ReceipeDetails.GetIngredients();
				      String Steps=ReceipeDetails.GetCookingSteps();
				      String Nutrients=ReceipeDetails.GetNutrients();
				      if (Nutrients==null) {
				    	  System.out.println("No data in nutrients");
				      }
				      
				      String ImageLink=ReceipeDetails.Getimg_link();
				      
				      driver.navigate().back();
				      System.out.println("/*-----------Category-------------*/");
				      System.out.println(Category);
				      System.out.println("/*-----------title-------------*/");
				      System.out.println(title);
				      System.out.println("/*-----------Receipe Link-------------*/");
				      System.out.println(ReceipeLink);
				      System.out.println("/*-----------Ingredients-------------*/");
				      System.out.println(Ingredients);
				      System.out.println("/*-----------Steps-------------*/");
				      System.out.println(Steps);
				      System.out.println("/*-----------Nutrients-------------*/");
				      System.out.println(Nutrients);
				      System.out.println("/*-----------ImageLink-------------*/");
				      System.out.println(ImageLink);
				  }
    		  }
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("Navigation through the receipe links under a particular category is unsuccessful as the link is not found");
		}
		  return new RecipeDetailsPage();
		  
		
	}

}
