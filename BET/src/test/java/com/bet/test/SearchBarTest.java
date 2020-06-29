package com.bet.test;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.bet.operations.Operations;
import com.bet.pagemodels.SearchPageModel;

import util.KeyWords;
import util.ScreenShot;


public class SearchBarTest 

{    
	WebDriver driver=null;
	WebElement element=null;
	ScreenShot shot=null;
	

	@Parameters({ "browser", "url" })
	@BeforeMethod(alwaysRun=true)
	private void setup(String browser,String url)
	{
		
		driver=KeyWords.browserStart(browser,url);

	}


	@Test(priority=1)
	private void searchPageDisplay() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"TRAVIS SCOTT");
		element=SearchPageModel.searchBarResult(driver);

		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();

		Assert.assertEquals("Search Results", title);

	}


	@Test(priority=2)
	private void searchResultDisplay() throws InterruptedException
	{
		
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"Snoop Dogg");

		element=SearchPageModel.searchBarResult(driver);

		Operations.click(driver, element);
		Thread.sleep(1000);
		
		boolean b=driver.findElement(By.xpath("//h2[contains(text(),'Ja Rule Claps Back After 50 Cent Suggests IG Battle Between Him And Snoop Dogg')]")).isDisplayed();

		Assert.assertTrue(b);


	}



	@Test(priority=3)
	private void invalidInputTest() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"Khjas%$#");

		element=SearchPageModel.searchBarResult(driver);

		Operations.click(driver, element);
		Thread.sleep(1000);
		

		boolean b=driver.findElement(By.xpath("//div[contains(text(),'SORRY, NO RESULTS ')]")).isDisplayed();

		Assert.assertTrue(b);


	}

	@Test(priority=4)
	private void emptyStringTest() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"    	");

		element=SearchPageModel.searchBarResult(driver);

		Operations.click(driver, element);
		
		Thread.sleep(1000);

		String title=driver.getTitle();
		
		Assert.assertEquals("Celebrities, Music, News, Entertainment, TV Shows & Videos | BET",title);


	}

	@Test(priority=5)
	private void searchUsingEnterKeyTest() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		Actions action=new Actions(driver);

		element=driver.findElement(By.xpath("//input[@name='q']"));

		action.moveToElement(element).sendKeys("dcsdcdscs",Keys.ENTER).perform();

		boolean b=driver.findElement(By.xpath("//div[contains(text(),'SORRY, NO RESULTS ')]")).isDisplayed();
		
		 
		shot.getScreenShot(driver,"invalid");
		
		Thread.sleep(1000);
		Assert.assertTrue(b);


	}


	@Test(priority=6)
	private void searchUsingSuggestion() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"bet");
		
		element=SearchPageModel.searchBarResult(driver);
		Operations.click(driver, element);
		
		Thread.sleep(1000);
		
		String title=driver.getTitle();
		
		Assert.assertEquals("Search Results",title);


	}



	@AfterMethod
	void quit(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			shot=new ScreenShot(); 
			shot.getScreenShot(driver, result.getName());
		}
		
		driver.quit();

	}


}
