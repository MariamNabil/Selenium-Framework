package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Addtocart extends PageBase
{

	public Addtocart(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	@FindBy(xpath="//*[@id=\"bar-notification\"]/div/p/a")
	WebElement shoppingcartpage;
	
	
	@FindBy(css="td.remove-from-cart")
	WebElement removebtn;
	
	
	@FindBy(css="input.qty-input")
	public WebElement quantitytxtbox;
	
	@FindBy(css="input.button-2.update-cart-button")
	WebElement updatecartbtn;
	
	@FindBy(css="td.subtotal")
	 public WebElement totalmount;
	
	@FindBy(css="div.no-data")
	public WebElement removingmessage;
	
	@FindBy(id="checkout")
	WebElement checkoutbtn;
	

	@FindBy(id="termsofservice")
	WebElement termsofservicechecked;
	
	
	
	
	public void opencheckoutpage()
	{
		clickbutton(termsofservicechecked);

		clickbutton(checkoutbtn);
	}
	
	
	public void removeproductfromcart()
	{
		clickbutton(removebtn);
		clickbutton(updatecartbtn);
	}

	
	public void updatequantity(String amount)
	{
		
		//clear first quantity(old)
		cleartxt(quantitytxtbox);
		
		send_textsendkeys(quantitytxtbox, amount);
		clickbutton(updatecartbtn);
		
	}
	
	public void openshoppingcartpage()
	{
		clickbutton(shoppingcartpage);
	}
	
	
}
