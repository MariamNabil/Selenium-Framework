package Tests;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelReader;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisteration;

//Writing Test Cases
public class Userregisterationwithddtusingexcelfile extends TestBase //(inheritance Drivers)
{
	//Public on Class Level
	HomePage homeobject;
	UserRegisteration registerobject;
	LoginPage loginpageobject;
	
	
	@DataProvider(name="ReadingExcelData")
	public static Object[][] UserregisterationData() throws IOException
	{
		//get Data from excel reader class
		ExcelReader er=new ExcelReader();

			return er.getexceldata();
	}

	
	@Test(priority=1,dataProvider="ReadingExcelData")
	public void Usercanregistersuccessfully(String fn,String ln,String email,String pass)
	{
		//Calling Methods Here
		homeobject=new HomePage(driver); //inherit object from Class homepage ->yro7 driver yt3mlo replace with chrome driver ly 3rfnaha fi l test base.
		homeobject.open_Registeration_page();//open register link from home page.
		registerobject=new UserRegisteration(driver);
		registerobject.userregisteration(fn, ln,email, pass);
		Assert.assertTrue(registerobject.registersuccessmessage.getText().contains("Your registration completed"));
		registerobject.user_log_out();
		homeobject.open_Login_page();
		loginpageobject=new LoginPage(driver);
		loginpageobject.userlogin(email,pass);
		registerobject.user_log_out();


	}


	

}
