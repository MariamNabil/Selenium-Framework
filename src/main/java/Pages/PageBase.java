package Pages;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase 
{
	protected WebDriver driver;
    public JavascriptExecutor jse;
    public Select select; //For every select used
    public Actions action; //For Example to move by mouse.
    
	//Create Constructor

	public PageBase (WebDriver driver)
	{
		PageFactory.initElements(driver, this);  // DRIVER//PAGE
	}

	//More Refactoring 
	//protected->3la l package dy bs (Pages),
	//Methods Static--> kol l page objects hyst3mloha msh ha5od mnha object.

	
	
	
	
	//click buttons
	protected  static void clickbutton(WebElement btn)
	{
		btn.click();
	}

	//Set text for elements (sendkeys)
	protected  static void send_textsendkeys(WebElement element ,String value)
	{
		element.sendKeys(value);
	}
	

	
	public  void Scrollpage() 
	{
		jse.executeScript("scrollBy(0,2500)");// scroll to the below of the page
	}

public void cleartxt(WebElement element)
{
	element.clear();

}



}
