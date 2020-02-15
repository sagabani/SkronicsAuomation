package com.skyronic.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase(){
		
		prop =new Properties();
		FileInputStream fs;
		try {
			fs = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\skyronic\\qa\\config\\config.properties");
	
				prop.load(fs);
		
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}	catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		//To launch Chrome
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
			System.setProperty("webdriver.chrome.driver","chromedriver.exe" );
			driver =new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			// To load url
			driver.get(prop.getProperty("url"));
			

	}
	}
