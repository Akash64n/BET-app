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

public class StyleTest 
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
	private void style_Videos() throws InterruptedException
	{
		extentTest=extent.startTest("style_Videos");
		element=StylePageModel.style_Videos(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Videos",title);
		
	}
	
	@Test(priority=2)
	private void style_Fashion() throws InterruptedException
	{
		extentTest=extent.startTest("style_Fashion");
		element=StylePageModel.style_Fashion(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Fashion",title);
		
		
	}
	
	@Test(priority=3)
	private void style_Beauty() throws InterruptedException
	{
		extentTest=extent.startTest("style_Beauty");
		element=StylePageModel.style_Beauty(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Beauty",title);
		
		
	}
	

	@Test(priority=4)
	private void style_Lifestyle() throws InterruptedException
	{
		extentTest=extent.startTest("style_Lifestyle");
		element=StylePageModel.style_Lifestyle(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Living",title);
		
		
	}
	
	@Test(priority=5)
	private void style_TheGlamGapSeries() throws InterruptedException
	{
		extentTest=extent.startTest("style_TheGlamGapSeries");
		element=StylePageModel.style_TheGlamGapSeries(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Glam Gap",title);
		
		
	}
	
	@Test(priority=6)
	private void style_ExclusiveInterviews() throws InterruptedException
	{
		extentTest=extent.startTest("style_ExclusiveInterviews");
		element=StylePageModel.style_ExclusiveInterviews(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Mahisha Dellinger Is Taking Over the Hair Care Industry | BET | BET CURLS Beauty Brands | Curls",title);
		
		
	}
	
	@Test(priority=7)
	private void style_AllStyle() throws InterruptedException
	{
		extentTest=extent.startTest("style_AllStyle");
		element=StylePageModel.style_AllStyleButton(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Style",title);
		
		
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
