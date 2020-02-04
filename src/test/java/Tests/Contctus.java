package Tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Contactus;
import Pages.HomePage;

public class Contctus extends TestBase

{
HomePage homeobj;
Contactus cu;

String name="Test_User";
String email="Test@test.com";
String enquiry="Test_Message";

@Test
public void Sendcontctinfo()
{
	homeobj=new HomePage(driver);
	cu=new Contactus(driver);
	homeobj.opencontactuspage();
	cu.sendmailenqiry(name, email, enquiry);
	Assert.assertTrue(cu.sucessmessage.getText().contains("Your enquiry has been successfully sent to the store owner"));


}
	
	
	
	
	
	
}
