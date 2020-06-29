package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VideosPageModel 
{
	
	
	public static WebElement videos_BetBuzz(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='BET BUZZ' and @href='/news/bet-buzz.html']"));
        
		return element;
	
	}
	
	public static WebElement videos_106PARKMICCHECK(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//a[@href='/shows/106-park-mic-check.html' and @data-top-event='homepage:navigation:top nav:videos:sub nav categories:2']"));
    
	return element;

	}
	
	public static WebElement videos_TheGlamGapSeries(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//a[text()='THE GLAM GAP SERIES' and @data-top-event='homepage:navigation:top nav:videos:sub nav categories:3']"));
    
	return element;

	}
	
	public static WebElement videos_AllVideosButton(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//span[text()='See All Videos']"));
    
	return element;

	}

}