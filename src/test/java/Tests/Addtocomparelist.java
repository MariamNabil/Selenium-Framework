package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.productdetailspage;
import Pages.searchforproduct;

public class Addtocomparelist extends TestBase
{
	String firstproductname="Apple MacBook Pro 13-inch";
	String Secoendproductname="Asus N551JK-XO076H Laptop";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;
	HomePage homepageobj;
	ComparePage  ComparePageobj;
	

	@Test(priority=1)
	public void searchforproductsuccessfully()
	{
		searchobj=new searchforproduct(driver);
		productdetailsobj=new productdetailspage(driver);
		ComparePageobj=new ComparePage(driver);
		
			//search for the first product then add to compare list
			searchobj.searchforproductusingautosuggest("MacB");
			Assert.assertTrue(productdetailsobj.prodctnamebreedcrumb.getText().equalsIgnoreCase(firstproductname));
			productdetailsobj.ClickonAddtocomparelistbtn();

	}
	
	
	@Test(priority=2)
	public void searchforproduct2successfully()
	{
		searchobj=new searchforproduct(driver);
		productdetailsobj=new productdetailspage(driver);
		ComparePageobj=new ComparePage(driver);
				
			//search for the second product then add to compare list
			searchobj.searchforproductusingautosuggest("Asus");
			Assert.assertTrue(productdetailsobj.prodctnamebreedcrumb.getText().equalsIgnoreCase(Secoendproductname));
			productdetailsobj.ClickonAddtocomparelistbtn();
		

	}
	
	
	@Test(priority=3)
	public void Usergotocomparisonpagee()
	{
	ComparePageobj=new ComparePage(driver);
	 try {                                     //to load the 2 products
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    driver.navigate().to("https://demo.nopcommerce.com" +"/compareproducts");
    Assert.assertTrue(ComparePageobj.product1name.getText().equals(firstproductname));
    Assert.assertTrue(ComparePageobj.product2name.getText().equals(Secoendproductname));
 
	ComparePageobj.compareproducts();
	}
	
	@Test(priority=4)
	public void Usercanclearproducttocomparelist()
	{
		ComparePageobj=new ComparePage(driver);
		ComparePageobj.clearcomprelist();
		
	}
	
	
	
	

}
