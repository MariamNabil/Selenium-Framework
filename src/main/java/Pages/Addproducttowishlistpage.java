package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Addproducttowishlistpage extends PageBase
{

	public Addproducttowishlistpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy (name="removefromcart")
	WebElement removefromcartbtn;
	
	
	//For assertion for product name if added successfully or not.
	@FindBy (xpath="/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[5]/a\r\n")
	 public WebElement productname;
	
	@FindBy (css ="div.no-data")
	public WebElement checkremovedproductresult;
	
	@FindBy (name="updatecart")
	WebElement updatecartbtn;
	
	
	public void userupdatewishlist()
	{
		clickbutton(updatecartbtn);
	}
	
	
	public void remmoveproductfromwishlist()
	{
		clickbutton(removefromcartbtn);
	}
	
}
