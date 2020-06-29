package com.bet.operations;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Operations
{
	
	public static WebDriver click(WebDriver driver,WebElement element)
	{
		
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		return driver;
		
		
	}
	

	public static void mouseOver(WebDriver driver,WebElement element)
	{
		
		String strJavaScript="var element=arguments[0];"
				+ "var mouseEventObj=document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent('mouseover',true,true);"
				+ "element.dispatchEvent(mouseEventObj);";
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript(strJavaScript,element);
		
		
	}
	
	
	
}
