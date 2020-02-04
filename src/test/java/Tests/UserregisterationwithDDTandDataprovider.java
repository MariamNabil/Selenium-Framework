package Tests;



import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisteration;

//Writing Test Cases
public class UserregisterationwithDDTandDataprovider extends TestBase //(inheritance Drivers)
{
	//Public on Class Level
	HomePage homeobject;
	UserRegisteration registerobject;
	LoginPage loginpageobject;

	@DataProvider(name="TestData")
	public static Object[][] UserData()
	{
		return new Object[][] 
		{{"Maro","Nabil","pllk@gmail.com","123456789"},{"roka","ali","pollll@gmail.com","789665"}};
	}


	@Test(priority=1,dataProvider="TestData")
	public void Usercanregistersuccessfully(String fn,String ln,String email,String pass)
	{
		//Calling Methods Here
		homeobject=new HomePage(driver); //inherit object from Class homepage ->yro7 driver yt3mlo replace with chrome driver ly 3rfnaha fi l test base.
		homeobject.open_Registeration_page();//open register link from home page.
		registerobject=new UserRegisteration(driver);
		registerobject.userregisteration(fn, ln, email, pass);

		//    ---------------------------------------  //
		//Assertions To make Sure Our test cases Running Successfully.
		//yofdl wgod l assertion fi l test cases
		Assert.assertTrue(registerobject.registersuccessmessage.getText().contains("Your registration completed"));
		registerobject.user_log_out();
		homeobject.open_Login_page();
		loginpageobject=new LoginPage(driver);
		loginpageobject.userlogin(email, pass);
		registerobject.user_log_out();

	}
	


}
