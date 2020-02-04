package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase

{

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id="Email")
	WebElement Email;

	@FindBy(id="Password")
	WebElement Password;

	@FindBy(css="input.button-1.login-button")
	WebElement loginbtn;

	public void userlogin(String email,String pass)
	{
		send_textsendkeys(Email,email);
		send_textsendkeys(Password,pass);
		clickbutton(loginbtn);

	}

}
