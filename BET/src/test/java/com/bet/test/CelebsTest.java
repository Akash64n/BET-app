package com.bet.test;


import util.KeyWords;

import util.ScreenShot;

import com.bet.pagemodels.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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

public class CelebsTest 
{
	WebDriver driver=null;
	WebElement element=null;
	ScreenShot shot=null;
	ExtentReports extent=null;
	ExtentTest extentTest=null;


	@BeforeTest
	private void setExtent()
	{
		extent=new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html",true);
		extent.addSystemInfo("Host Name","Akash PC");
		extent.addSystemInfo("User Name","Akash Negi");
		extent.addSystemInfo("Environment","QA");


	}

	@AfterTest
	private void endReports()
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
	private void celebs_News() throws InterruptedException
	{
		extentTest=extent.startTest("celebs_News");
		element=CelebsPageModel.celebs_News(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Latest Black Celebrity News, Gossip and More | BET",title);
		
	}
	
	@Test(priority=2)
	private void celebs_Movies() throws InterruptedException
	{
		extentTest=extent.startTest("celebs_Movies");
		element=CelebsPageModel.celebs_Movies(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Original Movies: Season 18 | BET",title);
		
		
	}
	
	@Test(priority=3)
	private void celebs_TvShows() throws InterruptedException
	{
		extentTest=extent.startTest("celebs_TvShows");
		element=CelebsPageModel.celebs_TvShows(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Watch Full Episodes Of Your Favorite BET Shows | BET",title);
		
		
	}
	

	@Test(priority=4)
	private void celebs_Exclusives() throws InterruptedException
	{
		extentTest=extent.startTest("celebs_Exclusives");
		element=CelebsPageModel.celebs_Exclusives(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Celebrity Exclusives",title);
		
		
	}
	
	@Test(priority=5)
	private void celebs_AllCelebs() throws InterruptedException
	{
		extentTest=extent.startTest("celebs_AllCelebs");
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
