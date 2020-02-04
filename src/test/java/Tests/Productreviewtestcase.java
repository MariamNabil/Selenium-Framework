package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductReview;
import Pages.UserRegisteration;
import Pages.productdetailspage;
import Pages.searchforproduct;

public class Productreviewtestcase extends TestBase
{
	HomePage homeobject;
	UserRegisteration registerobject;
	ProductReview reviewpageobject;
	
	String productname="Apple MacBook Pro 13-inch";
	searchforproduct searchobj;
	productdetailspage productdetailsobj;
	String pass="123456789";
	String Firstname="Maro";
	String lastname="Nabil";
	String Email="mm3oo853mm@gmail.com";
	String title="TestTittle";
	String reviewtext="Testtext";
	
	
	//---------------------------------------------------------
	//Scenario 
	//1-User Must Register to add reviews on Products.
	//2-User search for product
	//3-User Add Review for product
	//4-Make sure this Review added successfully.
	//5-User log out

	//Only registered users can write reviews
	//----------------------------------------------------------

	@Test(priority=1)
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
  public void Usercanaddreviewsuccessfully()
  {
	  reviewpageobject=new ProductReview(driver);
	  productdetailsobj.openaddreviewpage();
	  reviewpageobject.addreview(title, reviewtext);
	  Assert.assertTrue(reviewpageobject.Reviewnotifiction.getText().contains("Product review is successfully added."));
	  System.out.println(reviewpageobject.Reviewnotifiction.getText());
  }
	@Test(priority=4)
	public void registeredusercanlogoutsuccessfully()
	{
		registerobject.user_log_out();
	}

	
}
