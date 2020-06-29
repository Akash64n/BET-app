package com.bet.test;


import util.KeyWords;

import util.ScreenShot;

import com.bet.pagemodels.*;
import com.bet.operations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CelebsTest 
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
	private void celebs_News() throws InterruptedException
	{
		element=CelebsPageModel.celebs_News(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Latest Black Celebrity News, Gossip and More | BET",title);
		
	}
	
	@Test(priority=2)
	private void celebs_Movies() throws InterruptedException
	{
		element=CelebsPageModel.celebs_Movies(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Original Movies: Season 18 | BET",title);
		
		
	}
	
	@Test(priority=3)
	private void celebs_TvShows() throws InterruptedException
	{
		element=CelebsPageModel.celebs_TvShows(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Watch Full Episodes Of Your Favorite BET Shows | BET",title);
		
		
	}
	

	@Test(priority=4)
	private void celebs_Exclusives() throws InterruptedException
	{
		element=CelebsPageModel.celebs_Exclusives(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Celebrity Exclusives",title);
		
		
	}
	
	@Test(priority=5)
	private void celebs_AllCelebs() throws InterruptedException
	{
		element=CelebsPageModel.celebs_AllCelebsButton(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Latest Black Celebrity News, Gossip and More | BET",title);
		
		
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
