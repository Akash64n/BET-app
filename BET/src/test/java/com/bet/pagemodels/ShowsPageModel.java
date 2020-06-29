package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShowsPageModel 
{
	
	
	
	public static WebElement shows_BetAwards(WebDriver driver)
	{
		WebElement element =driver.findElement(By.xpath("//a[text()='BET AWARDS 2019']"));
        
		return element;
	
	}
	

	
	
	
	public static WebElement shows_AmericanSoul(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='AMERICAN SOUL']"));
        
		return element;
	
	
	}
	
	
	public static WebElement shows_TheOval(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='THE OVAL']"));
        
		return element;
	
	
	}
	
	
	public static WebElement shows_QueenCollective(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='QUEEN COLLECTIVE']"));
        
		return element;
	
	
	}
	

	public static WebElement shows_FullEpisodes(WebDriver driver)
	{
		WebElement element =driver.findElement(By.xpath("//a[text()='Full Episodes' and @data-top-event='homepage:navigation:top nav:shows:full episodes']"));
        
		return element;
		
		
	
	}
	
	public static WebElement shows_TvSchedule(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='TV Schedule' and @data-top-event='homepage:navigation:top nav:shows:tv schedule']"));
        
		return element;
		
	
	}
	
	public static WebElement shows_AllShowsButton(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//span[text()='See All Shows']"));
        
		return element;
		
	
	}
	
	
	
}
