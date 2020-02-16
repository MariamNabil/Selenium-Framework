package Tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Addtocart;
import Pages.Checkoutpage;
import Pages.Order_infoafterconfirmordercheckout;
import Pages.UserRegisteration;
import Pages.productdetailspage;
import Pages.searchforproduct;



public class GuestCheckoutProductFromCardTest extends TestBase 
{
	Checkoutpage cobj;
	UserRegisteration uobj;
	Addtocart addtocartobj;
	
	Order_infoafterconfirmordercheckout oobj;
	String firstname="maro";
	String lastname="nabil";
	String Emaill="maronabil@gmail.com";
	String countryname ="Egypt";
	String address="testtaddress";
	String postcode="1236548";
	String  phone="03216549870";
	String  cityy="Giza";
	
	String productname="Apple MacBook Pro 13-inch";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;
	

	@Test(priority=1)
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
	@Test(priority=2)
	public void usercanaddproducttocart()
	{
		addtocartobj=new Addtocart(driver);
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
		addtocartobj.openshoppingcartpage();
		addtocartobj.updatequantity("4");
		Assert.assertTrue(addtocartobj.totalmount.getText().contains("$7,200.00"));
	}


	
	@Test (priority=3)
	public void UsercanCheckoutasaGuest() throws InterruptedException
	{
		cobj=new Checkoutpage(driver);
	
		addtocartobj=new Addtocart(driver);
		oobj=new Order_infoafterconfirmordercheckout(driver);
		
		addtocartobj.opencheckoutpage();
		cobj.openCheckoutpageasguest();

		
		cobj.Guestusercheckoutproduct(firstname,lastname, Emaill, countryname, address, postcode, phone, cityy);

		Assert.assertTrue(cobj.productnameee.getText().contains(productname));

		cobj.confirmorder();

		Assert.assertTrue(cobj.thanxlabel.isDisplayed());
		Assert.assertTrue(cobj.successmessage.getText().contains("Your order has been successfully processed!"));

		cobj.enterorderdetails();
		oobj.printinvoiceorder();
		//cobj.printingfinalaction();

		}

}
