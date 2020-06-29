package com.bet.pagemodels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageModel
{

	
	public static WebElement searchNav(WebDriver driver)
	{
		WebElement element = driver.findElement(By.xpath("//li[@class='header__nav__aux__link header__search__toggle icon']"));
		return element;
		
	}
	
	
	public static WebDriver searchBar(WebDriver driver,String keys)
	{
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(keys);
		return driver;
		
	}
	
	
	public static WebElement searchBarResult(WebDriver driver)
	{

		WebElement element=driver.findElement(By.xpath("//Button[@class='header__search__submit icon-search-2']"));
		return element;
		
	}
	
	
	
	
	
}
