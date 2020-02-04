package Pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class searchforproduct extends PageBase 

{

	public searchforproduct(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id="small-searchterms")
	WebElement searchbox;
	
	@FindBy(css="input.button-1.search-box-button")
	WebElement searchbutton;
	
	@FindBy(id="ui-id-1")
	List<WebElement> productlist; //l autocomlete
	
	@FindBy(linkText="Apple MacBook Pro 13-inch")
	WebElement prodcttitle;
	
	
	public void openprojectdetailspage()
	{
		clickbutton(prodcttitle);
	}
	
	public void searchforproductt(String productname)
	{
		send_textsendkeys(searchbox, productname);
		clickbutton(searchbutton);
	}
	
	public void searchforproductusingautosuggest(String searchtxt)
	{
		//bktb awl kam 7arf 
		send_textsendkeys(searchbox, searchtxt);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 productlist.get(0).click(); //hat awl wa7d fi l list w dos 3leh //index 0 
	}


}
