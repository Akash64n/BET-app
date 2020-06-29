package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StylePageModel 
{
	
	public static WebElement style_Videos(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='VIDEOS' and @href='/style/videos.html']"));
	    
		return element;

	}
	
	public static WebElement style_Fashion(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='FASHION']"));
	    
		return element;

	}
	
	public static WebElement style_Beauty(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='BEAUTY']"));
	    
		return element;

	}
	
	public static WebElement style_Lifestyle(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='LIFESTYLE']"));
	    
		return element;

	}
	
	public static WebElement style_TheGlamGapSeries(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='THE GLAM GAP SERIES' and @data-top-event='homepage:navigation:top nav:style:sub nav categories:5']"));
	    
		return element;

	}
	
	public static WebElement style_ExclusiveInterviews(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='EXCLUSIVE INTERVIEWS' and @href='/video/style/2020/curls-mahisha-dellinger-taking-over-hair-industry.html']"));
	    
		return element;

	}
	
	public static WebElement style_AllStyleButton(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//span[text()='See All Style']"));
	    
		return element;

	}
	
	
	
	
}


