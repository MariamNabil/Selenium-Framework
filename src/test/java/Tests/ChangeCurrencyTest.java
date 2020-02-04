package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.productdetailspage;
import Pages.searchforproduct;

public class ChangeCurrencyTest extends TestBase
{
	HomePage homeobj;
	String productname="Apple MacBook Pro 13-inch";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;

    
	
    @Test(priority=1)
    public void Usercanchangecurreny()
    {
    	homeobj=new HomePage(driver);
    	homeobj.Change_Currency();
    	
    	
    	
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
			Assert.assertTrue(productdetailsobj.Amountsign.getText().contains("Ђ"));
			System.out.println(productdetailsobj.Amountsign.getText());
		}
		catch (Exception e)
		{
         System.out.println(" error occured " + e.getMessage());
		}

	}
    
    

    

}
