package com.bet.test;



import com.bet.pagemodels.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import util.KeyWords;
import util.ScreenShot;

import com.bet.operations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MusicTest 
{
	WebDriver driver=null;
	WebElement element=null;
	ScreenShot shot=null;
	ExtentReports extent;
	ExtentTest extentTest;
	
	
	@BeforeTest(alwaysRun=true)
	private void setExtent()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/Reports/ExtentReport.html",true);
		extent.addSystemInfo("Host Name","Akash PC");
		extent.addSystemInfo("User Name","Akash Negi");
		extent.addSystemInfo("Environment","QA");


	}
	
	@AfterTest(alwaysRun=true)
	private void closeExtent()
	{
		extent.flush();
		extent.close();


	}

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
			extentTest.log(LogStatus.FAIL,"Test Case FAILED is "+result.getName());
			extentTest.log(LogStatus.FAIL,"Test Case FAILED due to "+result.getThrowable());
			
			String path=ScreenShot.getScreenShot(driver,result.getName());
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(path));
			
		}
		else if(ITestResult.SKIP==result.getStatus())
		{
			extentTest.log(LogStatus.SKIP,"Test Case SKIPPED is"+result.getName());
		}

		else if(ITestResult.SUCCESS==result.getStatus())
		{
			extentTest.log(LogStatus.PASS,"Test Case PASSED is "+result.getName());


		}		
		extent.endTest(extentTest);
		
		driver.quit();

	}

}
