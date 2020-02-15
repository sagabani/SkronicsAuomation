package com.skyronic.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skyronic.qa.base.TestBase;

public class ProductDetailsPage extends TestBase {
	//Object Repository
	ProductsListPage pdtListPage;
	
	@FindBy(xpath="//button[contains(text(), 'Add to cart')]")
	WebElement addToCartbtn;
	
	@FindBy(css=".inventory")
	WebElement inStock;
	
	@FindBy(css=".product-title")
	WebElement pdtTitle;
	
	@FindBy(partialLinkText="Cart")
	WebElement cartNumber;
	
	@FindBy(xpath="//button[contains(text(), 'Out Of Stock')]")
	WebElement outOfStock;
	
	//To initialize webElemments
	
	public ProductDetailsPage(){
		PageFactory.initElements(driver, this);
		 pdtListPage= new ProductsListPage();
	
		
	}
//To verify pdt details on the PDP page
	
	public  boolean inStockDetails() {
		//pdtListPage.clickIpad4Mini();
		if(inStock.isDisplayed()==true){
			if (pdtTitle.isDisplayed()==true){
				if(addToCartbtn.isEnabled()==true){
					
				}
				}
			} return true;
	}
		//To add a product to cart and check the cart count
	public boolean addProductToCart(){
		String initCartNumber = cartNumber.getText(); 
		String latestCartNumber = "";
		
		addToCartbtn.click();
		latestCartNumber = cartNumber.getText();
		if (initCartNumber.equalsIgnoreCase(latestCartNumber)){
			return false;
		}
		return true;
	}

	//To check out of stock
	public boolean checkProductstock(){
		boolean active = true;
		while(active){
			if (!inStock.getText().endsWith("0")){
				addToCartbtn.click();
			}else{
				active = false;
			}
		}	
		return outOfStock.isDisplayed();
	}
	
}
