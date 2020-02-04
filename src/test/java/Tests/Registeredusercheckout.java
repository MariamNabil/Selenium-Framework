package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Addtocart;
import Pages.Checkoutpage;
import Pages.HomePage;
import Pages.Order_infoafterconfirmordercheckout;
import Pages.UserRegisteration;
import Pages.productdetailspage;
import Pages.searchforproduct;

public class Registeredusercheckout extends TestBase

{
	
	Checkoutpage obj;
	UserRegisteration regobj;
	String phonenum="01234567890";
	String countryname="Egypt";
	String city="Cairo";
	String zipcode="1853456";
	String address="testh address";
	
	HomePage homeobject;
	UserRegisteration registerobject;
	
	String pass="123496789";
	String Firstname="Maro";
	String lastname="Nabil";
	String Email="munjkpkm@gmail.com";
	
	String productname="Apple MacBook Pro 13-inch";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;
	

	Addtocart Addtocartobbj;
	
	Order_infoafterconfirmordercheckout oobj;
	
//Registeration process
	@Test(priority=1)
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

	
 //searching product process	
@Test(priority=2)
public void searchforproductsuccessfully()
{
	// ast5dmna try w catch 3shan 
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

//addtocart process
@Test(priority=3)
public void usercanaddproducttocart()
{
	
	Addtocartobbj=new Addtocart(driver);
	productdetailsobj=new productdetailspage(driver);
	productdetailsobj.clickonaddtocrtbtn();
	try 
	{
		Thread.sleep(1000);
	} 
	catch (InterruptedException e) 
	{
		e.printStackTrace();
	}
	Addtocartobbj.openshoppingcartpage();
	Addtocartobbj.updatequantity("4");
	Assert.assertTrue(Addtocartobbj.totalmount.getText().contains("$7,200.00"));
}


//checkout process
@Test(priority=4)
public void registeredusercancompletecheckoutprocess()
{
	
obj=new Checkoutpage(driver);
Addtocartobbj=new Addtocart(driver);
oobj=new Order_infoafterconfirmordercheckout(driver);

Addtocartobbj.opencheckoutpage();

obj.registeredusercheckoutproduct(countryname,address, zipcode,phonenum, city);
Assert.assertTrue(obj.productnameee.getText().contains(productname));

obj.confirmorder();

Assert.assertTrue(obj.thanxlabel.isDisplayed());
Assert.assertTrue(obj.successmessage.getText().contains("Your order has been successfully processed!"));

obj.enterorderdetails();
oobj.printorder();

}


//logout process
@Test(priority=5)
public void registeredusercanlogoutsuccessfully()
{
	registerobject.user_log_out();
}

	
}
