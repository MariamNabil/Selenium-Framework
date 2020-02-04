package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Addproducttowishlistpage;
import Pages.Addtocart;
import Pages.HomePage;
import Pages.productdetailspage;
import Pages.searchforproduct;

public class addcardtestcase extends TestBase

{
	String value="4";
	HomePage homepageobj;
	Addproducttowishlistpage obj;
	String productname="Apple MacBook Pro 13-inch";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;
	Addtocart Addtocartobbj;

	@Test(priority=1)
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


	@Test(priority=2)
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
		Addtocartobbj.updatequantity(value);
		Assert.assertTrue(Addtocartobbj.totalmount.getText().contains("$7,200.00"));
	}
	
	
	
	@Test(priority=3)
	public void usercanremoveproducttocart()
	{
		Addtocartobbj=new Addtocart(driver);
		Addtocartobbj.removeproductfromcart();
		Assert.assertTrue(Addtocartobbj.removingmessage.getText().contains("Your Shopping Cart is empty!"));

	}

}
