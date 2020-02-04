package Pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase
{

	public ComparePage(WebDriver driver) 
	{
		super(driver);
	}

	
	
	@FindBy(css="a.clear-list")
	WebElement Clearlistbtn;

	@FindBy(css="div.no-data")
	WebElement nodatalabel; //after clear

	@FindBy(tagName="tr")
	public List<WebElement> allrows;

	@FindBy(tagName="td")
	public List<WebElement> allcols;

	@FindBy (css="table.compare-products-table")
	WebElement comparetable;

	
	
	@FindBy (linkText="Apple MacBook Pro 13-inch")
	public WebElement product1name;
	
	@FindBy (linkText="Asus N551JK-XO076H Laptop")
	 public WebElement product2name;
	
	
	

	public void clearcomprelist()
	{
		clickbutton(Clearlistbtn);
	}
	

	public void compareproducts()
	{
		//Get all rows
		System.out.println(allrows.size());
		//Get data from each row
		for(WebElement row:allrows) 
		{
			System.out.println(row.getText()+"\t");
		}
		
		//Get all cols
		for(WebElement col:allcols) 
		{
			System.out.println(col.getText()+"\t");
		}

	}

	
	

	
	
}
