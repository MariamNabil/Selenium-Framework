package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Order_infoafterconfirmordercheckout extends PageBase
{

	public Order_infoafterconfirmordercheckout(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[1]/a[1]")
	WebElement printbtn;
	
	@FindBy(xpath="/html/body/div[6]/div[3]/div/div/div/div[1]/a[2]")
	WebElement printinvoicebtn;
	
	
	
	public void printorder()
	{
		clickbutton(printbtn);
	}
	
	public void printinvoiceorder() throws InterruptedException
	{
		clickbutton(printinvoicebtn);
		Thread.sleep(2000);
	}
	
}
