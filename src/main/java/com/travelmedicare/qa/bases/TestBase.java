package com.travelmedicare.qa.bases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.travelmedicare.qa.utils.WebEventListener;
import com.travelmedicare.qa.utils.TestUtils;




public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListener eventListener;
	public static EventFiringWebDriver e_driver;
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream file= new FileInputStream("C:\\Users\\Bimal\\eclipse-workspace\\TravelMedicare\\src\\main\\java\\com\\travelmedicare\\qa\\config\\config.properties");
			prop.load(file);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Bimal\\Desktop\\bimsfg\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bimal\\Desktop\\bimsfg\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String url = prop.getProperty("url");
		driver.get(url);
		
		
		

		
		
	}
	
	
}
