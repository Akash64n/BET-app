package com.bet.test;

import com.bet.pagemodels.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import util.KeyWords;
import util.ScreenShot;

import com.bet.operations.*;

import org.openqa.selenium.By;
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

public class BetPlusTest 
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
	private void StreamExclusiveOriginals() throws InterruptedException
	{
		extentTest=extent.startTest("StreamExclusiveOriginals");
		element=BetPlusPageModel.bet_StreamExclusiveOriginals(driver);
		Operations.click(driver, element);
		
		WebElement ele=driver.findElement(By.xpath("//input[@placeholder='Search Twitter']"));
		Thread.sleep(1000);

		Assert.assertEquals(ele.isDisplayed(), true);
		
		
	}
	
	@Test(priority=2)
	private void bet_GotoBetPlusButton() throws InterruptedException
	{
		extentTest=extent.startTest("bet_GotoBetPlusButton");
		element=BetPlusPageModel.bet_GotoBetPlusButton(driver);
		Operations.click(driver, element);
		
		WebElement ele=driver.findElement(By.xpath("//input[@placeholder='Search Twitter']"));
		
		Thread.sleep(1000);
		
		Assert.assertEquals(ele.isDisplayed(), true);
		
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
