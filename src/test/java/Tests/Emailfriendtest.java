package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailFriend;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegisteration;
import Pages.productdetailspage;
import Pages.searchforproduct;

public class Emailfriendtest extends TestBase
{
	HomePage homeobject;
	UserRegisteration registerobject;
	LoginPage loginpageobject;
	EmailFriend emf;
	
	String pass="123456789";
	String Firstname="Maro";
	String lastname="Nabil";
	String Email="mm3pps6283mm@gmail.com";
	String friendemail="bbb@tt.com";
	String personamessage="hello my friend";
	String productname="Apple MacBook Pro 13-inch";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;


	// -----------------------------------------------------------------
	                                                //Scanario 
                               	// 1-User register. 
                                //2-search for product 
	                           //3-send email to friend
                              //4-User logout
	@Test (priority=1)
	public void Usercanregistersuccessfully()
	{
		homeobject=new HomePage(driver); 
		homeobject.open_Registeration_page();
		registerobject=new UserRegisteration(driver);
		registerobject.userregisteration(Firstname, lastname,Email, pass);
		Assert.assertTrue(registerobject.registersuccessmessage.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2)
	public void searchforproductsuccessfully()
	{
		try 
		{
			searchobj=new searchforproduct(driver);
			productdetailsobj=new productdetailspage(driver);
			searchobj.searchforproductusingautosuggest("MacB");
			Assert.assertTrue(productdetailsobj.prodctnamebreedcrumb.getText().equalsIgnoreCase(productname));
		}
		catch (Exception e)
		{
         System.out.println(" error occured " + e.getMessage());
		}
	}

	@Test(priority=3)
	public void testsendmailfriend()
	{
		
		emf=new EmailFriend(driver);
		productdetailsobj.opensendfriendemailpage();
		emf.sendmailfriend(friendemail,personamessage);
	    Assert.assertTrue(emf.messagenotify.getText().contains("Your message has been sent."));
		
	}
	
	@Test (priority=4)
	public void registeredusercanlogoutsuccessfully()
	{
		registerobject.user_log_out();
	}
	

}
