package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class productdetailspage extends PageBase
{

	public productdetailspage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(css="strong.current-item")
	public WebElement prodctnamebreedcrumb;

	@FindBy (xpath="//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[10]/div[3]/input")
	public WebElement emailfriendbtn;

	@FindBy(css="span.price-value-4")
	public WebElement Amountsign; //For check about Euro ->amount of specif product and it's sign has changed to be euro sign

	//Add Review for a product
	@FindBy(linkText ="Add your review")
	WebElement Addreviewlink;
	
	//Add product to wish list
	@FindBy(id="add-to-wishlist-button-4")
	WebElement wishlistbutton;
	
	//Wish list itself 
	@FindBy(xpath="//*[@id=\"bar-notification\"]/div/p/a")
	WebElement wishlist;
	
	//Add to compare list button
	@FindBy(css="input.button-2.add-to-compare-list-button")
	 WebElement Addtocomparelistbtn;
	
	//Add product to card
	@FindBy(id="add-to-cart-button-4")
	WebElement addtocartbtn;
	
	
	//product comparison page
	@FindBy(xpath="//*[@id=\"bar-notification\"]/div/p/a")
	WebElement  comparisonpagebtn;
	
	public void gotocomparisonpage()
	{
		clickbutton(comparisonpagebtn);
	}
	
	
	public void ClickonAddtocomparelistbtn()
	{
		clickbutton(Addtocomparelistbtn);
	}
	
	public void openwishlist()
	{
		clickbutton(wishlist);
	}

	public void gotowishlist()
	{
		clickbutton(wishlistbutton);
	}
	

	public void openaddreviewpage()
	{
		clickbutton(Addreviewlink);
	}

	public void opensendfriendemailpage()
	{
		clickbutton(emailfriendbtn);
	}

public void clickonaddtocrtbtn()
{
	clickbutton(addtocartbtn);}






}
