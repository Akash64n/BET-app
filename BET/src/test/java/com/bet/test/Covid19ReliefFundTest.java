package com.bet.test;

import java.util.Iterator;



import java.util.Set;
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

public class Covid19ReliefFundTest 
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
	
	@Test()
	private void covid19ReliefFund()
	{
		extentTest=extent.startTest("covid19ReliefFund");
		element=Covid19ReliefFundModel.SOSReliefEffortSpecial(driver);
		Operations.click(driver, element);
		
		element=Covid19ReliefFundModel.covid19_DONATE(driver);
		Operations.click(driver, element);
		
		Set<String> allTabs=driver.getWindowHandles();
		Iterator<String> itr=allTabs.iterator();
		itr.next();
		driver.switchTo().window(itr.next());
		
		String title=driver.getTitle();
		
		Assert.assertEquals("BET COVID-19 Donate", title);
		
		
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
