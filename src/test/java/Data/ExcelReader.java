package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	static FileInputStream fis =null;



	public FileInputStream getfileinputstream()
	{
		String filepath=System.getProperty("user.dir")+"/src/test/java/Data/testData.xlsx";//da l path bta3 l file 
		File srcfFile=new File(filepath);//da aly  ht2ra mno
		try {
			fis=new FileInputStream(srcfFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test data file not found -->check file path");
			System.exit(0);
		}
		return fis;
	}

	public Object [][] getexceldata() throws IOException
	{
		//fis aly ana m3rfah hnady 3la getinputstream 3shan bykon gwah path l file
		
		fis=getfileinputstream();
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(0);

		int numberofrows=(sh.getLastRowNum()+1); //ymshy l a5r row
		int numberofcols=4;
		String [][] arrayexceldata=new String[numberofrows][numberofcols]; 
		for (int i = 0; i < numberofrows; i++)
		{
			for (int j = 0; j < numberofcols;j++)
			{
				XSSFRow row=sh.getRow(i);
				arrayexceldata[i][j]=row.getCell(j).toString(); //get cells From columns
			}

		}
		wb.close(); //b2fl l stream 3shan l fis lazm gy mn file inputstream lazm n2flo
		return arrayexceldata;


	}



}
