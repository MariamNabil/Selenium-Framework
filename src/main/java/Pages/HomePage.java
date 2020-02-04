package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase  
{

	public HomePage(WebDriver driver)
	{
		super(driver);
		jse=(JavascriptExecutor) driver; //3rfto fi l Pagebase w hna bdelo value intialize 3shan ast5dmha.
		action=new Actions (driver);
	}
	
	
     //Redirect to register link.
	// for page factory to find register link by link text.
	
	// Elements   ---------------- Methods
	
	@FindBy(linkText="Register")
	WebElement registerlink;      
	
	@FindBy(linkText ="Log in")
	  WebElement loginbtutton;
	
	//contact us button on home page
		@FindBy(linkText="Contact us")
		WebElement contactusbutton;
		
	// Currency drop down list.	
		@FindBy(id="customerCurrency")
		WebElement CustomerCurrency;
		
	// Computers Tab
		@FindBy(xpath="/html/body/div[6]/div[2]/ul[1]/li[1]/a")
		WebElement computerstab;
		
	//Notebooks tab	
		@FindBy(xpath="/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
		WebElement Notebookstab;
		
		//function used on product move menu test case
		public void selectnotebookmenu()
		{
			action.moveToElement(computerstab).moveToElement(Notebookstab).click().build().perform(); //simulate as user..
		}
	
		
	public void Change_Currency()
	{
		select=new Select(CustomerCurrency); //Select from DropDown List.
		select.selectByIndex(1); //Euro
		
	}
		
		
	public void open_Registeration_page()
	{
		//registerlink.click(); 
		//reusing  registerlink.click(); 
		clickbutton(registerlink); 
	}
	
	public void open_Login_page()
	{
		clickbutton(loginbtutton);  
	}
	public void opencontactuspage()
	{
		Scrollpage();
		clickbutton(contactusbutton);
		
	}
	
	
	
	
}
