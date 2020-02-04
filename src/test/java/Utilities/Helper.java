package Utilities;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



// Hna hn3rf an lw 7sl error 3n tre2 l testng runner lma y3ml run  l kol method w yshof l result     


public class Helper
{
	//Method take a screen shot when the test case fail.
	// l method dy hta5od driver aly htsht3'l 3leh fi l website
	//screenshot name htkon asm l method aly hyt3mlha run.

	public static void  captureScreenshots(WebDriver driver,String screenshotname)
	{
		//lazm ykon fi mkan save ll screenshots 
		//hdeha destination l path ll screenshots folder
		//Destination
		Path dest=Paths.get("./ScreenShots",screenshotname+".png");// Destination aly htro7 t3ml bih save b asm l screenshot .png gwa folde l screenshots.

		try {
			Files.createDirectories(dest.getParent()); //geb l desniation .
			FileOutputStream output=new FileOutputStream(dest.toString()); //Streaming mn l destination to save image w n7otha i variable l output
			output.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)); // 5od l screen shot b3d ma ft7t l stream by3mlha save as bytes.
			output.close(); // lazm t3ml screeming 	 b3d ma save it 
		}
		catch (IOException e) 
		{
			System.out.println("Exception while taking screenshots"+e.getMessage());
		}

		
		
	}

}
