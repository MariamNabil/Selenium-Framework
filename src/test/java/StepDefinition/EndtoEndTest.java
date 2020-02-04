package StepDefinition;

import org.openqa.selenium.support.ui.Sleeper;
import org.testng.Assert;

import Pages.Addtocart;
import Pages.Checkoutpage;
import Pages.Order_infoafterconfirmordercheckout;
import Pages.productdetailspage;
import Pages.searchforproduct;
import Tests.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class EndtoEndTest extends TestBase
{
	searchforproduct searchObject;
	productdetailspage productDetails;
	Addtocart cartObject;
	Checkoutpage checkoutObject;
	Order_infoafterconfirmordercheckout orderObject;
	String productname = "Apple MacBook Pro 13-inch";
	String firstname="maro";
	String lastname="nabil";
	String Emaill="maronabil@gmail.com";
	String countryname ="Egypt";
	String address="testtaddress";
	String postcode="1236548";
	String  phone="03216549870";
	String  cityy="Giza";
	
	@Given("^User in homepage$")
	public void user_in_homepage()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com"));
	 
	}

	@When("^User search for \"([^\"]*)\"$")
	public void user_search_for(String productname)
	{
		searchObject = new searchforproduct(driver);
		searchObject.searchforproductusingautosuggest(productname);
		productDetails = new productdetailspage(driver);
		Assert.assertTrue(productDetails.prodctnamebreedcrumb.getText().contains(productname));
	}

	@When("^choose to buy (\\d+) items$")
	public void choose_to_buy_items(int arg1) 
	{
		cartObject = new Addtocart(driver);
		productDetails = new productdetailspage(driver);
		productDetails.clickonaddtocrtbtn();
		cartObject.openshoppingcartpage();
		cartObject.updatequantity("4");
		Assert.assertTrue(cartObject.totalmount.getText().contains("$7,200.00"));
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	  
	}

	@When("^check Cartpage and enter personal details and plce the order$")
	public void check_Cartpage_and_enter_personal_details_and_plce_the_order() 
	{
		checkoutObject = new Checkoutpage(driver);
		cartObject.opencheckoutpage();
		try 
		{
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		checkoutObject.openCheckoutpageasguest();
		checkoutObject.Guestusercheckoutproduct(firstname,lastname, Emaill, countryname, address, postcode, phone, cityy);
		checkoutObject.confirmorder();
	}

	@Then("^he can view the order aand download the invoice$")
	public void he_can_view_the_order_aand_download_the_invoice() throws InterruptedException 
	{
		checkoutObject = new Checkoutpage(driver);
		orderObject= new Order_infoafterconfirmordercheckout(driver);
		checkoutObject.enterorderdetails();
		orderObject.printinvoiceorder();
	}


}
