package kovair.JenkinsIntegration1;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class JenkinsIntegrationTestNGClass {
  
	
	
  	
  @Test
  public void NGTest1() {
	  System.out.println("In Test 1");
	  Assert.assertTrue(true);
	  //Assert.fail();
  }
  
  
  @Test
  public void NGTest2() {
	  System.out.println("In Test 2");
	  //Assert.fail();
	  //Assert.assertTrue(true);
	  throw new SkipException("NGTest2 skipped");
	  
  }
  
  @Test
  public void NGTest3() {
	  System.out.println("In Test 3");
	  Assert.assertTrue(true);
  }
}
