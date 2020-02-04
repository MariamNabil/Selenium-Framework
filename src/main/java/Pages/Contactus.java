package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contactus extends PageBase
{

	public Contactus(WebDriver driver) 
	{
		super(driver);
		
	}
	

	
	
	
	@FindBy(id="FullName")
	WebElement name;
	
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Enquiry")
	WebElement enquiry;
	
	@FindBy(name="send-email")
	WebElement submitbutton;
	
	
	
	@FindBy(css="div.result")
	 public WebElement sucessmessage;//For assertion on contact us testcase.
	
	
	
	public void  sendmailenqiry(String send_name,String send_email,String send_enquiry)
	{
		send_textsendkeys(name, send_name);
		send_textsendkeys(email, send_email);
		send_textsendkeys(enquiry, send_enquiry);
		clickbutton(submitbutton);
		
		
	}
	

}
