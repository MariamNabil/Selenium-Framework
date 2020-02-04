package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReview extends PageBase
{

	public ProductReview(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement Reviewtitle;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement Reviewtext;
	
	@FindBy(name="add-review")
	WebElement submitbtn;
	
	@FindBy(id="addproductrating_4")
	WebElement Rating4Rdiobtn;
	
	@FindBy(css="div.result")
	public WebElement Reviewnotifiction;
	
	
	public void addreview(String tit,String rtxt)
	{
		send_textsendkeys(Reviewtitle, tit);
		send_textsendkeys(Reviewtext, rtxt);
		clickbutton(Rating4Rdiobtn);
		clickbutton(submitbtn);
	}
}
