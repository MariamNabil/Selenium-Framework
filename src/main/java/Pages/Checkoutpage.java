package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class Checkoutpage extends PageBase
{

	public Checkoutpage(WebDriver driver) 
	{
		super(driver);
	}


	@FindBy(id="BillingNewAddress_FirstName")
	WebElement fn;


	@FindBy(id="BillingNewAddress_LastName")
	WebElement ln;

	@FindBy(id="BillingNewAddress_Email")
	WebElement email;

	@FindBy(id="BillingNewAddress_CountryId")
	WebElement countrylist;

	@FindBy(id="BillingNewAddress_City")
	WebElement city;	

	@FindBy(id="BillingNewAddress_Address1")
	WebElement address1;

	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipcode;

	@FindBy(id="BillingNewAddress_PhoneNumber")
	WebElement phonenumber;

	@FindBy(xpath="//*[@id=\"billing-buttons-container\"]/input")
	WebElement Continuebtn;


	@FindBy(id="shippingoption_1")
	WebElement shippingmethod;

	@FindBy(xpath="	//*[@id=\"shipping-method-buttons-container\"]/input\r\n")
	WebElement continuebuttononshippingmethod;

	@FindBy(id="paymentmethod_0")
	WebElement paymentmethod;

	@FindBy(xpath="	//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement continuebuttononpaymentmethod;

	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input\r\n")
	WebElement paymentinfocontinuebutton;


	@FindBy(linkText="Apple MacBook Pro 13-inch")
	public WebElement productnameee;

	@FindBy(xpath="//*[@id=\"confirm-order-buttons-container\"]/input")
	WebElement confirmorderbutton;

	@FindBy(css="h1")
	public WebElement thanxlabel;


	@FindBy(css="div.title")
	public WebElement successmessage;


	@FindBy(linkText="Click here for order details.")

	WebElement orderlinkdetails;
	
	@FindBy(xpath="//*[@id=\"sidebar\"]//print-preview-button-strip//cr-button[1]")

	WebElement printaction;


	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/input[1]")

	WebElement Checkoutasguestbutton;

	public void  openCheckoutpageasguest()

	{
		clickbutton(Checkoutasguestbutton);
	}


	public void  enterorderdetails()

	{
		clickbutton(orderlinkdetails);
	}
	
	public void printingfinalaction()
	{
		clickbutton(printaction);
	}



	public void registeredusercheckoutproduct(String countryname,String address,
			String postcode,String phone,String cityy)
	{
		// selection from drop down list
		select=new Select(countrylist);
		select.selectByVisibleText(countryname);


		send_textsendkeys(address1, address);
		send_textsendkeys(zipcode, postcode);
		send_textsendkeys(phonenumber, phone);
		send_textsendkeys(city, cityy);

		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		clickbutton(Continuebtn);

		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		clickbutton(shippingmethod);
		clickbutton(continuebuttononshippingmethod);

		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		clickbutton(paymentmethod);
		clickbutton(continuebuttononpaymentmethod);

		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		clickbutton(paymentinfocontinuebutton);


		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}


	public void Guestusercheckoutproduct(String firstn,String Lastn,String emaillll,String countrynameee,String address,
			String postcodee,String phonee,String cityyy)
	{
		// selection from drop down list
		select=new Select(countrylist);
		select.selectByVisibleText(countrynameee);

		send_textsendkeys(fn, firstn);
		send_textsendkeys(ln, Lastn);
		send_textsendkeys(email, emaillll);
		
		send_textsendkeys(address1, address);
		send_textsendkeys(zipcode, postcodee);
		send_textsendkeys(phonenumber, phonee);
		send_textsendkeys(city, cityyy);

		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		clickbutton(Continuebtn);

		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		clickbutton(shippingmethod);
		clickbutton(continuebuttononshippingmethod);

		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		clickbutton(paymentmethod);
		clickbutton(continuebuttononpaymentmethod);

		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		clickbutton(paymentinfocontinuebutton);


		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}



	

	public void confirmorder()
	{
		clickbutton(confirmorderbutton);

		try 
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

	}

	public void Printorrder()
	{



	}








}
