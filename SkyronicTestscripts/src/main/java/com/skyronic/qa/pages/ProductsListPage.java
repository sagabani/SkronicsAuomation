package com.skyronic.qa.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skyronic.qa.base.TestBase;

public class ProductsListPage extends TestBase {
	
	//Object Repository
	
	@FindBy(linkText="iPad 4 Mini")
	WebElement iPad4Mini;
	
	@FindBy(linkText="H&M T-Shirt White")
	WebElement hmTshirtWhite;
	
	@FindBy(linkText="Charli XCX - Sucker CD")
	WebElement charliSuckerCD;
	
	//To initialise web elements
	public ProductsListPage(){
		PageFactory.initElements(driver, this);
	}
	
	//To verify if pdt shows in the required order
	public boolean sortProductValidate(WebDriver driver){

		String product = "";
		boolean sort = true;
		int i =1; // Product Row Count
		boolean valid =false;
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("iPad 4 Mini", "$ 500.01");
		hm.put("H&M T-Shirt White", "$ 10.99");
		hm.put("Charli XCX - Sucker CD", "$ 19.99");
		
		while (sort)
		{
			product = driver.findElement(By.cssSelector("body > div > div.page > div.product-container > div:nth-child("+i+")")).getText();
			if (!product.isEmpty()){
				System.out.println("Inside");
				if (i== 1 && product.endsWith(hm.get("iPad 4 Mini").toString())){
					System.out.println("iPad");
					i++;
				}
				else if (i== 2 && product.endsWith(hm.get("H&M T-Shirt White").toString())){
					System.out.println("H&M");
					i++;
				}
				else if (i== 3 && product.endsWith(hm.get("Charli XCX - Sucker CD").toString())){
					System.out.println("Charli");
					i++;
					sort = false;
					valid = true;					
				} else {
					sort = false;
					valid = false;
				}		
				
			}
				
		} return valid;
	}
	
	//To select a product
	public ProductDetailsPage clickIpad4Mini(){
		iPad4Mini.click();	
		return new ProductDetailsPage();
	}
}
