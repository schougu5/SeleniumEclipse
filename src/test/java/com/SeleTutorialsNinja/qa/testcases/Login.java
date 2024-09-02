package com.SeleTutorialsNinja.qa.testcases;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SeleTutorialsNinja.qa.utils.Base;

public class Login extends Base {

	WebDriver driver ;
	
	public Login() {
		
		super();
	}
	
		
	
	@BeforeMethod
	public void Setup() {
		
		driver = InitiliseBrowser("Chrome");
		
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver = CloseDriver();
		
	}
	
	
	
	@Test
	public void VerifyLoginWithValidCredentials() {
		
		
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		//driver = Base.Setup();
		
		driver.get("https://tutorialsninja.com/demo/");
		
		//driver = Base.TearDown();
		
		
		
		
		//Same logic as find element by driver using xpath and click on Login button
		
		Assert.assertTrue(true, "Return true");
		//driver.quit();
//		String expectedURL = "https://tutorialsninja.com/demo/1";
//		String CurrentUrl = driver.getCurrentUrl();
//		
//		
//		System.out.println("Current URL is " + CurrentUrl );
//		System.out.println("expected URL is " + expectedURL );
//		
//		Assert.assertEquals(CurrentUrl, expectedURL);
		
		
	}
	
	@Test(priority=1)
	public void VerifyLoginWithInvalidCredentials() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		driver.get("https://tutorialsninja.com/demo/");
		
		//Same logic as find element by driver using xpath and click on Login button
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		
		String expectedURL = "https://tutorialsninja.com/demo/1";
		String CurrentUrl = driver.getCurrentUrl();
		
		
		System.out.println("Current URL is " + CurrentUrl );
		System.out.println("expected URL is " + expectedURL );
		
		Assert.assertEquals(CurrentUrl, expectedURL);
		
		//Assert.assertTrue(false, "Return false");
		//driver.quit();
		
		
		
	}

	@Test (dataProvider = "LoginData")
	public void LoginUsingDataProvider(String email, String passwd) {
		
		System.out.println("email from Data provider " + email);
		System.out.println("Password from Data provider " + passwd);
		
	}
		
	
	@DataProvider(name = "LoginData")
	public Object[][] getData() {
		
	return new Object[][]  {
			{"abc@g.com", "12345"},
			{"abc@g.com", "123456"},
			{"abc@g.com", "123457"}
			};
			
		
	}

	
	
}
