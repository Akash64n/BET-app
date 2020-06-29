package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CelebsPageModel 
{
	public static WebElement celebs_Videos(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='VIDEOS' and @href='/video/celebrity/celebrity-videos.html']"));
	    
		return element;

	}

	
	public static WebElement celebs_News(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='NEWS']"));
	    
		return element;

	}
	
	public static WebElement celebs_Movies(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='MOVIES']"));
	    
		return element;

	}
	
	public static WebElement celebs_TvShows(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='TV SHOWS']"));
	    
		return element;

	}

	
	public static WebElement celebs_Exclusives(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='EXCLUSIVES']"));
	    
		return element;

	}
	
	public static WebElement celebs_AllCelebsButton(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//span[text()='See All Celebs']"));
	    
		return element;

	}
}
