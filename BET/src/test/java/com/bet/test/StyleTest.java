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

public class StyleTest 
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
	private void style_Videos() throws InterruptedException
	{
		element=StylePageModel.style_Videos(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Videos",title);
		
	}
	
	@Test(priority=2)
	private void style_Fashion() throws InterruptedException
	{
		element=StylePageModel.style_Fashion(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Fashion",title);
		
		
	}
	
	@Test(priority=3)
	private void style_Beauty() throws InterruptedException
	{
		element=StylePageModel.style_Beauty(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Beauty",title);
		
		
	}
	

	@Test(priority=4)
	private void style_Lifestyle() throws InterruptedException
	{
		element=StylePageModel.style_Lifestyle(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Living",title);
		
		
	}
	
	@Test(priority=5)
	private void style_TheGlamGapSeries() throws InterruptedException
	{
		element=StylePageModel.style_TheGlamGapSeries(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Glam Gap",title);
		
		
	}
	
	@Test(priority=6)
	private void style_ExclusiveInterviews() throws InterruptedException
	{
		element=StylePageModel.style_ExclusiveInterviews(driver);
		Operations.click(driver, element);
		Thread.sleep(1000);
		String title=driver.getTitle();
		Assert.assertEquals("Mahisha Dellinger Is Taking Over the Hair Care Industry | BET | BET CURLS Beauty Brands | Curls",title);
		
		
	}
	
	@Test(priority=7)
	private void celebs_style_AllStyle() throws InterruptedException
	{
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
			shot=new ScreenShot();
			shot.getScreenShot(driver, result.getName());
		}
		
		driver.quit();

	}

}
