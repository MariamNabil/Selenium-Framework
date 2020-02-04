package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class Productmovemenurtest extends TestBase
{
	HomePage homepgeobj;
	
	
	
	@Test
	public void testmovingmenuesuccessfully()
	{
		homepgeobj=new HomePage(driver);
		homepgeobj.selectnotebookmenu(); //BYxpath l movement....
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
		System.out.println(driver.getCurrentUrl());
		
	}
	
	
	
}
