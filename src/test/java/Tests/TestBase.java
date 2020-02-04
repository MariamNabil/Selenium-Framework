package Tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.openqa.selenium.remote.CapabilityType;

import Utilities.Helper;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;

public class TestBase extends AbstractTestNGCucumberTests
{

	//static -> fixed to be worked with
	public static WebDriver driver;
	
	public static String downloadPath = System.getProperty("user.dir") + "\\Downloads";
	
	public static ChromeOptions chromeOption()
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	//Before the whole test suite run -->Starting Driver

	@BeforeSuite
	@Parameters(("browser"))   //kda abl 7ga detect which driver to deal with.
	public void startdriver(@Optional("chrome") String browsername)
	{
		if (browsername.equalsIgnoreCase("chrome"))   //ignore class -> for ignoring capital and small letter.
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver= new ChromeDriver(chromeOption());
		}
		else if (browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")+"\\Drivers\\geckoriver.exe");
			driver= new FirefoxDriver();
		}
		else if (browsername.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		//userdir dy bt2ra l path bta3 l project kolo .
		//object From webdriver	


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);//Waiting for Dom Loading Complete.
		driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");//With Protocol

	}


	//Close driver

	@AfterSuite
	public void Stopdriver()
	{
		driver.quit();

	}

	//take a screenshot when test case fail and add it in the screenshot folder (after every method check result)
	//b3d kol test case at2kd sa7 wla la w lw la y5od screen shot ll bug w y3mlh save in screenshots folder
	//code knt htr aktbo fi kol test case clss ktbto fi l test base mra w7da msh hkrro 
	//btta5d fi 7alt l failure bs
	@AfterMethod
	public void screenshotfailure(ITestResult result)//testng runner result variable )
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("failed");
			System.out.println("taking screenshot......");

			Helper.captureScreenshots(driver, result.getName());// 5d asm l method aly 7slha fail mn l testng result
		}

	}


}
