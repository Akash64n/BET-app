package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Covid19ReliefFundModel 
{
	
	public static WebElement SOSReliefEffortSpecial(WebDriver driver)
    {
		
		WebElement element =driver.findElement(By.xpath("//img[@title='SOS COVID-19 RELIEF EFFORT']"));
	    
		return element;

	}
	
	public static WebElement covid19_DONATE(WebDriver driver)
    {
		
		WebElement element =driver.findElement(By.xpath("//a[contains(text(),'DONATE') and @href='https://untdwy.org/2RyR6v0']"));
	    
		return element;

	}



}
