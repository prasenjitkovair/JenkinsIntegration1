package kovair.JenkinsIntegration1;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class JenkinsIntegrationTestNGClass 
{
  
	WebDriver driver;
	
  	
	@org.testng.annotations.BeforeTest
	public void BeforeTest()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\PrasenjitOffice\\OneDrive - Kovair Software\\My Kovair Files\\EclipseWorkspace\\JenkinsIntegration1\\src\\test\\java\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://qa-app1/kovair94");
		
		driver.manage().window().maximize();
	}
	
	  @Test
	  public void NGTest1() {
		  System.out.println("In Test 1");
		  Assert.assertTrue(true);
		  //Assert.fail();
		  //takeSnapShot(driver);
	  }
  
  
	  @Test
	  public void NGTest2() {
		  System.out.println("In Test 2");
		  //Assert.fail();
		  Assert.assertTrue(true);
		  //throw new SkipException("NGTest2 skipped");
		  
	  }
	  
	  @Test
	  public void NGTest3() {
		  System.out.println("In Test 3");
		  Assert.assertTrue(true);
	  }
	  
	  @org.testng.annotations.AfterMethod
	  public void AfterMethod(ITestResult result) throws Exception
	  {
		  if(result.getStatus() == ITestResult.FAILURE)
		  {
			  takeSnapShot(driver,result.getName());
		  }
	  }
	  
	  
	  public static void takeSnapShot(WebDriver webdriver, String testname) throws Exception{

		  Random rand = new Random();
		  String filename = "D:\\PrasenjitOffice\\OneDrive - Kovair Software\\My Kovair Files\\EclipseWorkspace\\JenkinsIntegration1\\src\\test\\java\\scrpackage\\" + testname + rand.nextInt(1000)+ ".png";
	        //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File(filename);

	                //Copy file at destination

	                FileHandler.copy(SrcFile, DestFile);
	                
	                Reporter.log("<a href='"+ DestFile.getAbsolutePath() + "'> <img src='"+ DestFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
	                
	    }
	  
	  
	  @org.testng.annotations.AfterTest
	  public void AfterTest()
	  {
		  driver.quit();
	  }
	  
}
