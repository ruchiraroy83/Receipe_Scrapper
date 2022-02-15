package com.scrapper.qa.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.scrapper.qa.base.TestBase;
import com.scrapper.qa.util.Utilities;

import org.openqa.selenium.support.*;
import org.testng.Reporter;

public class RecipesListPage extends TestBase  {
	
	@FindBy(xpath="//a[@class='respglink']")
	List<WebElement> PageNo;
	@FindBy(xpath="//span[@class='rcc_recipename']")
	List<WebElement> ReceipeNameLink;
	RecipeDetailsPage recipesDetailsPage;
	public RecipesListPage() {
		PageFactory.initElements(driver, this);
	}
	RecipeDetailsPage ReceipeDetails=new RecipeDetailsPage();
	public RecipeDetailsPage ClickOnRecipe_GetDetails(String Category) throws IOException {
		 String path=prop.getProperty("excelPath");
		  Utilities xlutil=new Utilities(path);
		  xlutil.setCellData("Recipes",0,0,"TITLE");
		  xlutil.setCellData("Recipes",0,1,"CATEGORY");
		  xlutil.setCellData("Recipes",0,2,"INGREDIENTS");
		  xlutil.setCellData("Recipes",0,3,"METHOD/RECIPES");
		  xlutil.setCellData("Recipes",0,4,"NUTRIENT VALUES");
		  xlutil.setCellData("Recipes",0,5,"RECIPE IMAGE LINK");
		  xlutil.setCellData("Recipes",0,6,"LINK TO THE RECIPE");
		  
		  try {
			  List<WebElement> PageNum=PageNo;
   		  int totalPages=PageNum.size();
   		  
   		  System.out.println("Total No of pages="+totalPages);
   		  for (int j=0;j<totalPages;j++) {
   			  if (j>0) {
   				  PageNum=PageNo; 
   				  totalPages=PageNum.size();
   				  PageNo.get(j).click();
//   				  driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	    			  System.out.println("Page No: " +j);
   			  }
   			  
//   			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				List<WebElement> obj_receipeLinks=ReceipeNameLink;
				int lastRowCount=xlutil.getRowCount(prop.getProperty("excelPath"),"Recipes");
				lastRowCount=lastRowCount+1;
				  int totalLinksperPage = obj_receipeLinks.size();
				  for(int i=0;i<totalLinksperPage;i++){
					  System.out.println("Receipe no :"+i);
					  obj_receipeLinks=ReceipeNameLink;
					  totalLinksperPage=obj_receipeLinks.size();
					  obj_receipeLinks.get(i).click();
//					  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				      String title=ReceipeDetails.GetTitle();
				      xlutil.setCellData("Recipes",i+lastRowCount,0,title);
				      xlutil.setCellData("Recipes",i+lastRowCount,1,Category);
				      String ReceipeLink=ReceipeDetails.GetRecipeURL();
				      xlutil.setCellData("Recipes",i+lastRowCount,6,ReceipeLink);
				      String Ingredients=ReceipeDetails.GetIngredients();
				      xlutil.setCellData("Recipes",i+lastRowCount,2,Ingredients);
				      String Steps=ReceipeDetails.GetCookingSteps();
				      xlutil.setCellData("Recipes",i+lastRowCount,3,Steps);
				      String Nutrients=ReceipeDetails.GetNutrients();
				      System.out.println(Nutrients);
				      xlutil.setCellData("Recipes",i+lastRowCount,4,Nutrients);
				      if (Nutrients==null) {
				    	  xlutil.setCellData("Recipes",i+lastRowCount,4,"No data in nutrients");
				    	  System.out.println("No data in nutrients");
				      }
				      String ImageLink=ReceipeDetails.Getimg_link();
				      xlutil.setCellData("Recipes",i+lastRowCount,5,ImageLink);
				      driver.navigate().back();
				    
				  }
   		  }
		} catch (Exception e) {
//			e.printStackTrace();
			Reporter.log("Navigation through the receipe links under a particular category is unsuccessful as the link is not found");
		}
		  return new RecipeDetailsPage();
		  
		
	}

}
