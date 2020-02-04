package StepDefinition;

import org.testng.Assert;

import Pages.HomePage;
import Tests.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegisteration extends TestBase
{
	HomePage homepageobj;
    Pages.UserRegisteration userregistertionobj;
    
    @Given("^the User in home page$")
    public void the_User_in_home_page() throws Throwable 
    {
    	homepageobj=new HomePage(driver);

		homepageobj.open_Registeration_page();
    }

    
	@When("^i click on Register link$")
	public void i_click_on_Register_link() throws Throwable
	{
		
	    Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	@When("^i entered the user data$")
	public void i_entered_the_user_data() throws Throwable
	{
	    
		
	}
	@When("^i entered the \"([^\"]*)\" , \"([^\"]*)\", \"([^\"]*)\" , \"([^\"]*)\"$")
	public void i_entered_the(String Firstname, String Lastname, String Email, String Password) throws Throwable {
		userregistertionobj=new Pages.UserRegisteration(driver);
		userregistertionobj.userregisteration(Firstname, Lastname, Email, Password);

	}

	@Then("^the Registeration page displayed successfully$")
	public void the_Registeration_page_displayed_successfully() throws Throwable 
	{
		userregistertionobj.user_log_out();
	}

}
