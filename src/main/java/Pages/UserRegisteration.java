package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisteration extends PageBase   	//inheritance from page base through extends+class name.
{

	public UserRegisteration(WebDriver driver)   //Constructor
	{
		super(driver);
	}

	//Finding elements
	@FindBy(id="gender-female")
	WebElement genderradiobtn;

	@FindBy(id="FirstName")
	WebElement FirstName;

	@FindBy(id="LastName")
	WebElement LastName;

	@FindBy(name="DateOfBirthDay")
	WebElement DateOfBirthDay;

	@FindBy(name="DateOfBirthDay")
	WebElement DateOfBirthMonth;

	@FindBy(name="DateOfBirthYear")
	WebElement DateOfBirthYear;

	@FindBy(name="Email")
	WebElement Emailtxtbox;

	@FindBy(id="Password")
	WebElement password;

	@FindBy(id="ConfirmPassword")
	WebElement confirm_password;

	@FindBy(id="register-button")
	WebElement register_button;

	//assertion for register
	@FindBy(css="div.result")
	public WebElement registersuccessmessage;

	@FindBy(linkText="Log out")
	 WebElement logoutlink;
	
	@FindBy (linkText="My account")
	WebElement My_Account;
	
	//operating public  methods public->to be seen on project level

	public void userregisteration(String fn,String ln,String Email,String pass) 
	{
		//No fixed Parmeters //No hardcoded values.-->//Values will be taken from test cases.

		//	genderradiobtn.click(); 
		clickbutton(genderradiobtn);

		//FirstName.sendKeys("fn");//reusing from pagebase

		send_textsendkeys(FirstName, fn);
		send_textsendkeys(LastName, ln);
		send_textsendkeys(Emailtxtbox, Email);
		send_textsendkeys(password, pass);
		send_textsendkeys(confirm_password, pass);
		clickbutton(register_button);
	}
	
	public void user_log_out()
	{
		clickbutton(logoutlink);
	}

	public void openmyaccount()
	{
		clickbutton(My_Account);
		
	}
	
	
	

}
