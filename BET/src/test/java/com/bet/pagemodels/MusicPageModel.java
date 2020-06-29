package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MusicPageModel 
{

	public static WebElement music_Amplified(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='AMPLIFIED']"));
       
		return element;
	
	}
	
	public static WebElement music_RateTheBars(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='RATE THE BARS']"));
       
		return element;
	
	}
	
	public static WebElement music_MusicNews(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[text()='MUSIC NEWS']"));
       
		return element;
	
	}
	
	public static WebElement music_106PARKMICCHECK(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[@href='/shows/106-park-mic-check.html' and @data-top-event='homepage:navigation:top nav:music:sub nav categories:4']"));
       
		return element;
	
	}
	
	public static WebElement music_AllMusicButton(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//span[text()='See All Music']"));
       
		return element;
	
	}

}
