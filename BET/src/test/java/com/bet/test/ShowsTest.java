package com.bet.test;



import com.bet.pagemodels.*;


import util.KeyWords;
import util.ScreenShot;

import com.bet.operations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ShowsTest 
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
	private void shows_BetAwards() throws InterruptedException
	{
		element=ShowsPageModel.shows_BetAwards(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
	    Assert.assertEquals("2019 BET Awards | Meek Mill, Fantasia and More Added to the BET Awards", title);
		
		
	}
	
	
	@Test(priority=2)
	private void shows_AmericanSoul() throws InterruptedException
	{
		element=ShowsPageModel.shows_AmericanSoul(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("American Soul | BET | Season 1 Full Episodes, Exclusive Videos, Photos And More |", title);
		
		
	}
	
	@Test(priority=3)
	private void shows_TheOval() throws InterruptedException
	{
		element=ShowsPageModel.shows_TheOval(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Tyler Perry's The Oval | BET | Tyler Perry | Tyler Perry's The Oval | The Oval", title);
		
		
	}
	
	@Test(priority=4)
	private void shows_QueenCollective() throws InterruptedException
	{
		element=ShowsPageModel.shows_QueenCollective(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Extras and Exclusives | Queen Collective | BET HER | BET", title);
		
		
	}
	
	
	
	
	
	@Test(priority=5)
	private void shows_FullEpisodes() throws InterruptedException
	{
		element=ShowsPageModel.shows_FullEpisodes(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Unlocked Episodes | Episodes | BET", title);
		
		
	}
	
	@Test(priority=6)
	private void shows_TvSchedule() throws InterruptedException
	{
		element=ShowsPageModel.shows_TvSchedule(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("BET TV Schedule | Shows List | BET", title);
		
		
	}
	

	
	@Test(priority=7)
	private void shows_AllShows() throws InterruptedException
	{
		element=ShowsPageModel.shows_AllShowsButton(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Watch Full Episodes Of Your Favorite BET Shows | BET", title);
		
	}

	
	
	@AfterMethod
	private void quit(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			shot=new ScreenShot(); 
			shot.getScreenShot(driver, result.getName());
		}
		
		driver.quit();

	}

}
