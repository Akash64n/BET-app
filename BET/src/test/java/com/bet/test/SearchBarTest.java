package com.bet.test;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.bet.operations.Operations;
import com.bet.pagemodels.SearchPageModel;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import util.KeyWords;
import util.ScreenShot;


public class SearchBarTest 

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
	private void searchPageDisplay() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"TRAVIS SCOTT");
		element=SearchPageModel.searchBarResult(driver);

		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();

		Assert.assertEquals("Search Results", title);

	}


	@Test(priority=2)
	private void searchResultDisplay() throws InterruptedException
	{
		
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"Snoop Dogg");

		element=SearchPageModel.searchBarResult(driver);

		Operations.click(driver, element);
		Thread.sleep(1000);
		
		boolean b=driver.findElement(By.xpath("//h2[contains(text(),'Ja Rule Claps Back After 50 Cent Suggests IG Battle Between Him And Snoop Dogg')]")).isDisplayed();

		Assert.assertTrue(b);


	}



	@Test(priority=3)
	private void invalidInputTest() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"Khjas%$#");

		element=SearchPageModel.searchBarResult(driver);

		Operations.click(driver, element);
		Thread.sleep(1000);
		

		boolean b=driver.findElement(By.xpath("//div[contains(text(),'SORRY, NO RESULTS ')]")).isDisplayed();

		Assert.assertTrue(b);


	}

	@Test(priority=4)
	private void emptyStringTest() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"    	");

		element=SearchPageModel.searchBarResult(driver);

		Operations.click(driver, element);
		
		Thread.sleep(1000);

		String title=driver.getTitle();
		
		Assert.assertEquals("Celebrities, Music, News, Entertainment, TV Shows & Videos | BET",title);


	}

	@Test(priority=5)
	private void searchUsingEnterKeyTest() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		Actions action=new Actions(driver);

		element=driver.findElement(By.xpath("//input[@name='q']"));

		action.moveToElement(element).sendKeys("dcsdcdscs",Keys.ENTER).perform();

		boolean b=driver.findElement(By.xpath("//div[contains(text(),'SORRY, NO RESULTS ')]")).isDisplayed();
		
		Thread.sleep(1000);
		Assert.assertTrue(b);


	}


	@Test(priority=6)
	private void searchUsingSuggestion() throws InterruptedException
	{
		element=SearchPageModel.searchNav(driver);
		Operations.click(driver, element);

		driver=SearchPageModel.searchBar(driver,"bet");
		
		element=SearchPageModel.searchBarResult(driver);
		Operations.click(driver, element);
		
		Thread.sleep(1000);
		
		String title=driver.getTitle();
		
		Assert.assertEquals("Search Results",title);


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
