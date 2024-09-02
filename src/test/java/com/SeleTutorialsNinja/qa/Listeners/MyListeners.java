package com.SeleTutorialsNinja.qa.Listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

//import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MyListeners implements ITestListener {
	
		WebDriver driver;
	
	
	 /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	   * tag and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  public void onStart(ITestContext context) {
		  
		  System.out.println("onStart method invoked....");
		  
	  }
	
	  
	  
	public void onTestStart(ITestResult result) {
	 
				
		String testName = result.getName();
		
		System.out.println(testName + " got Started using onTestStart method.....");
		
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	  public void onTestSuccess(ITestResult result) {
		  
		  String testName = result.getName();
			
		  System.out.println(testName + " got PASSED using onTestSuccess method.....");
			
		  
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public void onTestFailure(ITestResult result) {
	    // not implemented
		  
		  String testName = result.getName();
			
		  System.out.println(testName + " got FAILED using onTestFailure method.....");
			
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
          // Define the path and save the screenshot
		  String filePath = "screenshots/" + result.getName() + ".png";
		  
		  	  
		  try {
			Files.copy(screenshot, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println("Screenshot saved: " + filePath);
		  
	  }

	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a method fails but has been annotated with successPercentage and this failure
	   * still keeps it within the success percentage requested.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS_PERCENTAGE_FAILURE
	   */
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  /**
	   * Invoked each time a test fails due to a timeout.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	  public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	 

	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	   * run and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
	    // not implemented
	  }
	}


