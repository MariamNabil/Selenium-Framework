package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Loadproperties
{
	public static Properties Userdata=Loadproperties("C:\\Users\\Mariam\\eclipse-workspace\\E-Commerce\\src\\main\\java\\properties\\Userdataproperties");//hna hdelo asm l file

	private static Properties Loadproperties(String path) //adelo l path 
	{
		Properties pro=new Properties(); //ba5od object mn l properties 
		//Stream for reading file.
		//da gy mn l java input output stream
		try {
			FileInputStream stream =new FileInputStream(path);
			try {
				pro.load(stream);
			} 
			catch (IOException e)
			{
				System.out.println("error occured ::"+e.getMessage());

			}
		} catch (FileNotFoundException e) 
		{
			System.out.println("error occured ::"+e.getMessage());
		}                                     //hna lazm y3ml try ,catch 3shan lw m3rfsh y2ra l file


		return pro;
	}

	

}
