package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewsPageModel 
{
	
	public static WebElement news_ReclaimYourVote(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//a[text()='#RECLAIMYOURVOTE']"));
    
	return element;

	}
	
	public static WebElement news_Videos(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//a[text()='VIDEOS' and @href='/news/bet-news.html']"));
    
	return element;

	}
	
	public static WebElement news_Coronavirus(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//a[text()='CORONAVIRUS']"));
    
	return element;

	}
	
	
	public static WebElement news_National(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//a[text()='NATIONAL']"));
    
	return element;

	}
	
	
	public static WebElement news_Sports(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//a[text()='SPORTS']"));
    
	return element;

	}
	
	public static WebElement news_ExclusiveInterviews(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//a[text()='EXCLUSIVE INTERVIEWS' and @href='/shows/bet-news-special/extras-and-exclusives.html']"));
    
	return element;

	}
	

	
	public static WebElement news_AllNewsButton(WebDriver driver)
	{
		
	WebElement element =driver.findElement(By.xpath("//span[text()='See All News']"));
    
	return element;

	}
	

	

}
