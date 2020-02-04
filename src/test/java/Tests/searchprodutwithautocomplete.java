package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.productdetailspage;
import Pages.searchforproduct;

public class searchprodutwithautocomplete extends TestBase
{
	String productname="Apple MacBook Pro 13-inch";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;

	@Test
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


}
