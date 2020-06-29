package com.bet.test;

import java.util.Iterator;



import java.util.Set;
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

public class Covid19ReliefFundTest 
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
	
	@Test()
	private void covid19ReliefFund()
	{
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
			shot=new ScreenShot();
			shot.getScreenShot(driver, result.getName());
		}
		
		driver.quit();

	}

}
