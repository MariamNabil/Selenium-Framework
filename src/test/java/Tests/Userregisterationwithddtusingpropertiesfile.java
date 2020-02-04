package Tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import Data.Loadproperties;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisteration;

//Writing Test Cases
public class Userregisterationwithddtusingpropertiesfile extends TestBase //(inheritance Drivers)
{
	//Public on Class Level
	HomePage homeobject;
	UserRegisteration registerobject;
	LoginPage loginpageobject;
	

	String Firstname=Loadproperties.Userdata.getProperty("firstname"); //hna bgeb l values aly fi l property file....
	String lastname=Loadproperties.Userdata.getProperty("lastname");
	String Email=Loadproperties.Userdata.getProperty("email");
	String pass=Loadproperties.Userdata.getProperty("password");
	@Test
	public void Usercanregistersuccessfully()
	{
		//Calling Methods Here
		homeobject=new HomePage(driver); //inherit object from Class homepage ->yro7 driver yt3mlo replace with chrome driver ly 3rfnaha fi l test base.
		homeobject.open_Registeration_page();//open register link from home page.
		registerobject=new UserRegisteration(driver);
		registerobject.userregisteration(Firstname, lastname,Email, pass);

                        //    ---------------------------------------  //
		//Assertions To make Sure Our test cases Running Successfully.
		//yofdl wgod l assertion fi l test cases
		Assert.assertTrue(registerobject.registersuccessmessage.getText().contains("Your registration completed"));

	}
	//Write Here Priority here after test word
	@Test(dependsOnMethods="Usercanregistersuccessfully")
	public void registeredusercanlogoutsuccessfully()
	{
		registerobject.user_log_out();
	}

	@Test(dependsOnMethods="registeredusercanlogoutsuccessfully")
	public void usercanloginsuccessfully()
	{
		homeobject.open_Login_page();
		loginpageobject=new LoginPage(driver);
		loginpageobject.userlogin(Email,pass);
	}

	

}
