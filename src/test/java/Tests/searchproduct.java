package Tests;
import org.testng.annotations.Test;


import org.testng.Assert;

import Pages.productdetailspage;
import Pages.searchforproduct;

public class searchproduct extends TestBase

{
	String productname="Apple MacBook Pro 13-inch";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;

	@Test
	public void searchforproductsuccessfully()
	{
		searchobj=new searchforproduct(driver);
		productdetailsobj=new productdetailspage(driver);
		searchobj.searchforproductt(productname);
		// to confirm that he entered product written on searchbox directly without autocomplete.
		searchobj.openprojectdetailspage();
		Assert.assertTrue(productdetailsobj.prodctnamebreedcrumb.getText().equalsIgnoreCase(productname));
	}




}
