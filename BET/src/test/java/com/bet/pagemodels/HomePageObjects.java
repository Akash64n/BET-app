package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects
{
  

	public static WebElement homePage(WebDriver driver)
	{
		
		WebElement element =driver.findElement(By.xpath("//a[@href='/']"));
		
		return element;
	}
	

	public static WebElement home_Shows(WebDriver driver)
	{

		WebElement element =driver.findElement(By.xpath("//a[text()='Shows']"));

		return element;

	}

	public static WebElement home_Music(WebDriver driver)
	{

		WebElement element =driver.findElement(By.xpath("//a[text()='Music']"));

		return element;

	}

	public static WebElement home_Videos(WebDriver driver)
	{

		WebElement element =driver.findElement(By.xpath("//a[text()='VIDEOS' and @href='/video.html']"));

		return element;

	}

	public static WebElement home_News(WebDriver driver)
	{

		WebElement element =driver.findElement(By.xpath("//a[text()='News']"));

		return element;

	}

	public static WebElement home_Celebs(WebDriver driver)
	{

		WebElement element =driver.findElement(By.xpath("//a[text()='Celebs']"));

		return element;

	}

	public static WebElement home_Style(WebDriver driver)
	{

		WebElement element =driver.findElement(By.xpath("//a[text()='STYLE']"));
		return element;

	}



	public static WebElement home_BetPlus(WebDriver driver)
	{

		WebElement element =driver.findElement(By.xpath("//a[text()='BET+']"));
		return element;

	}

	public static WebElement home_LiveTV(WebDriver driver)
	{

		WebElement element =driver.findElement(By.xpath("//span[text()='LIVE TV']"));

		return element;

	}

}
