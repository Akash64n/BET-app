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

public class NewsTest 


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
	private void news_ReclaimYourVote() throws InterruptedException
	{
		element=NewsPageModel.news_ReclaimYourVote(driver);
		driver=Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Reclaim Your Vote | BET | 2020 Election | Vote | #ReclaimYourVote | RECLAIM YOUR VOTE",title);

	}

	@Test(priority=2)
	private void news_Videos() throws InterruptedException
	{
		element=NewsPageModel.news_Videos(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Video News | Video | BET",title);


	}

	@Test(priority=3)
	private void news_Coronavirus() throws InterruptedException
	{
		element=NewsPageModel.news_Coronavirus(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Coronavirus",title);


	}


	@Test(priority=4)
	private void news_National() throws InterruptedException
	{
		element=NewsPageModel.news_National(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Latest National News & Stories | BET",title);


	}

	@Test(priority=5)
	private void news_Sports() throws InterruptedException
	{
		element=NewsPageModel.news_Sports(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Sports News & Stories | BET",title);


	}


	@Test(priority=6)
	private void news_ExclusiveInterviews() throws InterruptedException
	{
		element=NewsPageModel.news_ExclusiveInterviews(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("BET News Special Extras & Exclusives",title);


	}

	@Test(priority=7)
	private void news_AllNews() throws InterruptedException
	{
		element=NewsPageModel.news_AllNewsButton(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Breaking Entertainment News | BET",title);


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
