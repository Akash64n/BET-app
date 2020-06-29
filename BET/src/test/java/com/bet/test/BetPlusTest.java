package com.bet.test;

import com.bet.pagemodels.*;

import util.KeyWords;
import util.ScreenShot;

import com.bet.operations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BetPlusTest 
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
	private void StreamExclusiveOriginals() throws InterruptedException
	{
		element=BetPlusPageModel.bet_StreamExclusiveOriginals(driver);
		Operations.click(driver, element);
		
		WebElement ele=driver.findElement(By.xpath("//input[@placeholder='Search Twitter']"));
		Thread.sleep(1000);

		Assert.assertEquals(ele.isDisplayed(), true);
		
		
	}
	
	@Test(priority=2)
	private void bet_GotoBetPlusButton() throws InterruptedException
	{
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
			shot=new ScreenShot();
			shot.getScreenShot(driver, result.getName());
		}
		
		driver.quit();

	}

}
