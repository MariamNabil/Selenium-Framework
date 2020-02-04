package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Addproducttowishlistpage;
import Pages.HomePage;
import Pages.productdetailspage;
import Pages.searchforproduct;

public class Addingproducttowishlist extends TestBase
{

	HomePage homepageobj;
	Addproducttowishlistpage obj;
	String productname="Apple MacBook Pro 13-inch";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;

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
	public void Usercanaddproducttowishlist()
	{
		obj=new Addproducttowishlistpage(driver);
		productdetailsobj=new productdetailspage(driver);
		productdetailsobj. gotowishlist();
		productdetailsobj.openwishlist();
		Assert.assertTrue(obj.productname.getText().contains("Apple MacBook Pro 13-inch"));
		System.out.println(obj.productname.getText());
		
	}
	@Test(priority=3)
	public void Usercanremoveproducttowishlist()
	{
		obj=new Addproducttowishlistpage(driver);
		productdetailsobj=new productdetailspage(driver);
		
		obj.remmoveproductfromwishlist();
		obj.userupdatewishlist();
		Assert.assertTrue(obj.checkremovedproductresult.getText().contains("empty!"));
		System.out.println(obj.checkremovedproductresult.getText());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
