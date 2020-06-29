package util;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KeyWords
{
	private static WebDriver driver;
	public static WebDriver browserStart(String name)
	{
		if(name.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;
		
		
	}
	
	public static WebDriver browserStart(String name,String url)
	{
		driver=browserStart(name);
		driver.get(url);
		return driver;
	}
	

	public void openUrl(String url)
	{
		driver.get(url);
	}
	

}
