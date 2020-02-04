package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_account extends PageBase
{

	public My_account(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(id="OldPassword")
	WebElement old_password;
	
	@FindBy(id="NewPassword")
	WebElement new_password;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirm_password;

	@FindBy(css="input.button-1.change-password-button")
	  WebElement chngepassbutton;
	
	@FindBy(linkText="Change password")
	  WebElement Changepasswordlink;
	
	public void openchangdpasspage()
	{
		clickbutton(Changepasswordlink);
	}
	
	public void Usercanchangepssword(String oldpass,String newpass)
	{
		send_textsendkeys(old_password, oldpass);
		send_textsendkeys(new_password, newpass);
		send_textsendkeys(confirm_password, newpass);
		clickbutton(chngepassbutton);
		
	}
	

	

}
