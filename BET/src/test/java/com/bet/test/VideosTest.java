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

public class VideosTest 
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
	private void videos_BetBuzz() throws InterruptedException
	{
		element=VideosPageModel.videos_BetBuzz(driver);
		Operations.click(driver, element);	
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("BET BUZZ",title);
		
		
	}
	
	@Test(priority=2)
	private void videos_106PARKMICCHECK() throws InterruptedException
	{
		element=VideosPageModel.videos_106PARKMICCHECK(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();	
		Assert.assertEquals("106 & PARK: MIC CHECK | Mic Check | BET | 106 & Park | Music | Music News",title);
		
		
	}
	
	@Test(priority=3)
	private void music_videos_TheGlamGapSeries() throws InterruptedException
	{
		element=VideosPageModel.videos_TheGlamGapSeries(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Glam Gap",title);
		
	
	}
	

	@Test(priority=4)
	private void videos_AllVideos() throws InterruptedException
	{
		element=VideosPageModel.videos_AllVideosButton(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Video",title);
	
	
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
