package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.My_account;
import Pages.UserRegisteration;

public class My_Account extends TestBase //3shan ykon 3ndna driver w nb2a sha3'leen 3leh
{

	HomePage homeobject;
	UserRegisteration registerobject;
	My_account myaccobj;
	LoginPage loginobj;

	//Data change a lot so data driven
	String oldpass="123456789";
	String newpass="1234567890";
	String Firstname="Maro";
	String lastname="Nabil";
	String Email="mm3333336943mm@gmail.com";


    //steps of test case
	//1-User register ,
	//2-clicks on My account ,3-Click on change password 4-Enter data,5-Click change password , 6-logout ,7-login with new password

	
	@Test(priority=1)
	public void Usercanregistersuccessfully()
	{
		homeobject=new HomePage(driver); 
		homeobject.open_Registeration_page();
		registerobject=new UserRegisteration(driver);
		registerobject.userregisteration(Firstname, lastname,Email, oldpass);
		Assert.assertTrue(registerobject.registersuccessmessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods="Usercanregistersuccessfully")
	public void registerdUsercanchangepassword()
	{
		myaccobj=new My_account(driver);
		registerobject.openmyaccount();
		myaccobj.openchangdpasspage();
		myaccobj.Usercanchangepssword(oldpass, newpass);
	}

	
	//to confirm entering with the new password

	@Test(dependsOnMethods="registerdUsercanchangepassword")
	public void registeredusercanlogoutsuccessfully()
	{
		registerobject.user_log_out();
	}

	
	@Test(dependsOnMethods="registeredusercanlogoutsuccessfully")
	public void usercanloginsuccessfully()
	{
		homeobject.open_Login_page();
		loginobj=new LoginPage(driver);
		loginobj.userlogin(Email,newpass);
	}

}
