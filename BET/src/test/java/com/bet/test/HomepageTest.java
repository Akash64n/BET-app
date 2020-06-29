package com.bet.test;



import com.bet.pagemodels.*;


import util.KeyWords;
import util.ScreenShot;

import com.bet.operations.*;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomepageTest 
{
	WebDriver driver=null;
	WebElement element=null;
	ScreenShot shot=null;
	KeyWords keys=null;

	@Parameters({ "browser", "url" })
	@BeforeMethod(alwaysRun=true)
	private void setup(String browser,String url)
	{
		
		driver=KeyWords.browserStart(browser,url);

	}
	
	@Test(priority=1)
	
	private void homePage() throws InterruptedException
	{
	
		element=HomePageObjects.homePage(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Celebrities, Music, News, Entertainment, TV Shows & Videos | BET", title);
		
	}
	
	@Test(priority=2)
	private void home_Shows() throws InterruptedException
	{
		element=HomePageObjects.home_Shows(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Celebrities, Music, News, Entertainment, TV Shows & Videos | BET", title);
		
		
	}
	
	@Test(priority=3)
	private void home_Music() throws InterruptedException
	{
		element=HomePageObjects.home_Music(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Music | Latest News & Updates | BET", title);
		
		
	}
	
	@Test(priority=4)
	private void home_Videos() throws InterruptedException
	{
		element=HomePageObjects.home_Videos(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Video", title);
		
		
	}
	
	@Test(priority=5)
	private void home_News() throws InterruptedException
	{
		element=HomePageObjects.home_News(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Breaking Entertainment News | BET", title);
		
		
	}
	
	@Test(priority=6)
	private void home_Celebs() throws InterruptedException
	{
		element=HomePageObjects.home_Celebs(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Latest Black Celebrity News, Gossip and More | BET", title);
		
		
	}
	
	@Test(priority=7)
	private void home_Style() throws InterruptedException
	{
		element=HomePageObjects.home_Style(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
	    Assert.assertEquals("Style", title);
		
		
	}
	
	@Test(priority=8)
	private void home_BetPlus() 
	{
		element=HomePageObjects.home_BetPlus(driver);
		Operations.click(driver, element);
		Boolean b=driver.findElement(By.xpath("//input[@placeholder='Search Twitter']")).isDisplayed();
		Assert.assertTrue(b);
		
		
	}

	@Test(priority=9)
	private void home_LiveTV() throws InterruptedException
	{
		element=HomePageObjects.home_LiveTV(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("BET Networks Live TV", title);
		
		
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
