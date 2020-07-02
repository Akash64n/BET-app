package util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class ScreenShot 
{
	
	public static String getScreenShot(WebDriver driver,String testName)
	{
		
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot screen=(TakesScreenshot)driver;
		File src= screen.getScreenshotAs(OutputType.FILE);
		
		File screenShotName=new File(".//screenshots//"+testName+dateName+".png");

		try {
			FileHandler.copy(src,screenShotName);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String path=System.getProperty("user.dir")+ "/screenshots/"+testName+dateName+".png";
		
    return path;
	 
    }
	
}
