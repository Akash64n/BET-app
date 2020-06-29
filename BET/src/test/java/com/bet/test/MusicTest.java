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

public class MusicTest 
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
	private void music_Amplified() throws InterruptedException
	{
		element=MusicPageModel.music_Amplified(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Amplified",title);
		
	}
	
	@Test(priority=2)
	private void music_RateTheBars() throws InterruptedException
	{
		element=MusicPageModel.music_RateTheBars(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Rate The Bars | Episodes, Videos, Highlights & More | BET",title);
		
		
	}
	
	@Test(priority=3)
	private void music_MusicNews() throws InterruptedException
	{
		element=MusicPageModel.music_MusicNews(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Music | Latest News & Updates | BET",title);
		
		
	}
	
	@Test(priority=4)
	private void music_106PARKMICCHECK() throws InterruptedException
	{
		element=MusicPageModel.music_106PARKMICCHECK(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("106 & PARK: MIC CHECK | Mic Check | BET | 106 & Park | Music | Music News",title);
		
		
	}
	
	@Test(priority=5)
	private void music_AllMusic() throws InterruptedException
	{
		element=MusicPageModel.music_AllMusicButton(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Music | Latest News & Updates | BET",title);	
		
		
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
