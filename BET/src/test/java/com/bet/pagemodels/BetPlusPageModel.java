package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BetPlusPageModel 
{
	
	public static WebElement bet_StreamExclusiveOriginals(WebDriver driver)
    {
		
		WebElement element =driver.findElement(By.xpath("//a[text()='STREAM EXCLUSIVE ORIGINALS, TYLER PERRY AND CLASSIC HITS']"));
	    
		return element;

	}
	
	public static WebElement bet_GotoBetPlusButton(WebDriver driver)
    {
		
		WebElement element =driver.findElement(By.xpath("//span[text()='Go To BET+']"));
	    
		return element;

	}



}
