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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomepageSectionPreviewTest 
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
	private void shows_Preview()
	{
		extentTest=extent.startTest("shows_Preview");
		element=HomePageObjects.home_Shows(driver);
		Operations.mouseOver(driver, element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}


	}

	@Test(priority=2)
	private void Music_Preview()
	{
		extentTest=extent.startTest("Music_Preview");
		element=HomePageObjects.home_Music(driver);
		Operations.mouseOver(driver, element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Test(priority=3)
	private void Videos_Preview()
	{
		extent.startTest("Videos_Preview");
		element=HomePageObjects.home_Videos(driver);
		Operations.mouseOver(driver, element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	@Test(priority=4)
	private void News_Preview()
	{
		extentTest=extent.startTest("News_Preview");
		element=HomePageObjects.home_News(driver);
		Operations.mouseOver(driver, element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Test(priority=5)
	private void Celebs_Preview()
	{
		extentTest=extent.startTest("Celebs_Preview");
		element=HomePageObjects.home_Celebs(driver);
		Operations.mouseOver(driver, element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	@Test(priority=6)
	private void Style_Preview()
	{
		extentTest=extent.startTest("Style_Preview");
		element=HomePageObjects.home_Style(driver);
		Operations.mouseOver(driver, element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Test(priority=7)
	private void BetPlus_Preview()
	{
		extentTest=extent.startTest("BetPlus_Preview");
		element=HomePageObjects.home_BetPlus(driver);
		Operations.mouseOver(driver, element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


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
