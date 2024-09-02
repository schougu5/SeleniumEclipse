package com.SeleTutorialsNinja.qa.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public static WebDriver driver;
	
	
	
	public Base() {
		
		System.out.println("It is called by Super method...");
	}
	
		
	
	public static WebDriver InitiliseBrowser(String BrowserName) {
		
		
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			
			System.out.println("BrowerName processed is " + BrowserName );
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
			
				
		}else {
			
			System.out.println("BrowerName processed is " + BrowserName );
		}
		
		
		return driver;
		

		
	}

	public static WebDriver CloseDriver() {
		
		
		driver.quit();
		return driver;
	}
	
}
