package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriend extends PageBase

{
	public EmailFriend(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="FriendEmail")
	WebElement friendmail;
	
	
	@FindBy(id="PersonalMessage")
	WebElement personalmessage;
	
	@FindBy (name="send-email")
	WebElement send_emailbtn;
	
	@FindBy (css="div.result")
	 public WebElement messagenotify;
	
	public void sendmailfriend(String friendemail,String personamessage)
	{
		send_textsendkeys(friendmail, friendemail);
		send_textsendkeys(personalmessage, personamessage);
		clickbutton(send_emailbtn);
	}
	
	
	
	
	
	
}
