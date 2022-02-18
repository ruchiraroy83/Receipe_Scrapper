package com.scrapper.qa.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver=null;
  @Test
  public void f() {
	  if (driver.findElement(By.xpath("//div[contains(text(),'RECIPES')]")).isEnabled()) {
		  driver.findElement(By.xpath("//div[contains(text(),'RECIPES')]")).click();  
    	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	  if (driver.findElement(By.xpath("//div[@id='ctl00_cntleftpanel_ttlhealthtree_tvTtlHealth']")).isEnabled()){
    		  if (driver.findElement(By.xpath("//a[@id='ctl00_cntleftpanel_ttlhealthtree_tvTtlHealtht0']")).isEnabled());
    		  String strCategory=driver.findElement(By.xpath("//a[@id='ctl00_cntleftpanel_ttlhealthtree_tvTtlHealtht0']")).getText();
    		  driver.findElement(By.xpath("//a[@id='ctl00_cntleftpanel_ttlhealthtree_tvTtlHealtht0']")).click();
    		  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    		  List<WebElement> PageNo=driver.findElements(By.xpath("//a[@class='respglink']"));
    		  int totalPages=PageNo.size();
    		  String LastPgNo=PageNo.get(totalPages-1).getText();
    		  int LastPageNo=Integer.parseInt(LastPgNo);
    		  System.out.println(LastPgNo);
    		  for (int j=0;j<LastPageNo;j++) {
    			  if (j>0) {
    				  PageNo=driver.findElements(By.xpath("//a[@class='respglink']")); 
//    				  totalPages=PageNo.size();
    				  PageNo.get(j).click();
	    			  System.out.println("Page No:"+ j );

    			  }
 			  
    			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    		  List<WebElement> obj_receipeLinks=driver.findElements(By.xpath("//span[@class='rcc_recipename']"));
	    		  int totalLinksperPage = obj_receipeLinks.size();
	    		  for(int i=0;i<totalLinksperPage;i++){
	    			  System.out.println("Receipe no :="+i);
	    			  obj_receipeLinks=driver.findElements(By.xpath("//span[@class='rcc_recipename']"));
	    			  totalLinksperPage=obj_receipeLinks.size();
	    			  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//	    			  String strReceipeName=obj_receipeLinks.get(i).getText(); 
//	    			  System.out.println(strReceipeName);
	    			  obj_receipeLinks.get(i).click();
     			      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
////     			     JavascriptExecutor js = (JavascriptExecutor) driver;  //Interface
////     			    js.executeScript("window.scrollBy(0,3500)");
//	    		      driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
//	    			  if (driver.findElement(By.xpath("//div[@id='rcpinglist']")).isDisplayed()){
//	    				  String link=driver.getCurrentUrl();
//	    				  String ingredients=driver.findElement(By.xpath("//div[@id='rcpinglist']")).getText();
//	    				  String CookingMethod = driver.findElement(By.xpath("//div[@id='ctl00_cntrightpanel_pnlRcpMethod']")).getText();
//        				  System.out.println(link);
//	    				  System.out.println(ingredients);
//	    				  System.out.println(CookingMethod);
//	    				  if(driver.findElement(By.xpath("//div[@id='accompaniments']")).isDisplayed()) {
//	    					  String nutrients=(driver.findElement(By.xpath("//div[@id='accompaniments']")).getText());
//	    						
//	    						System.out.println(nutrients);
//	    					}else {
//	    						System.out.println("No Nutrients Data is present");
//	    					}
	    				  driver.navigate().back();
//	    				  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
////		    		      js.executeScript("window.scrollBy(0,50000)");
//	    				  
//	    				  
//	    			  }
	    		  }
	    	  }
	      }
	  
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\AC57872\\Desktop\\NumpyNinja\\softwares\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("window-size=1400,800");
		 options.addArguments("--headless"); ;
		 driver = new ChromeDriver(options);
//		 driver = new ChromeDriver();
		 driver.get("https://www.tarladalal.com/");
  }

  @AfterTest
  public void afterTest() {
  }

}
