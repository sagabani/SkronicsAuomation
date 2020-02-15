package com.skyronic.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skyronic.qa.base.TestBase;

public class ProductDetailsPage extends TestBase {
	
	ProductsListPage pdtListPage;
	
	@FindBy(xpath="//button[contains(text(), 'Add to cart')]")
	WebElement addToCartbtn;
	
	@FindBy(css=".inventory")
	WebElement inStock;
	
	@FindBy(css=".product-title")
	WebElement pdtTitle;
	
	public String inStockInfo;
	

	
	public ProductDetailsPage(){
		PageFactory.initElements(driver, this);
		 pdtListPage= new ProductsListPage();
		
		
	}
//	
//	public static void validatePdtDetails(){
//		//pdtListPage.clickIpad4Mini();
//		
//	}

	public  boolean inStockDetails() {
		pdtListPage.clickIpad4Mini();
		if(inStock.isDisplayed()==true){
			if (pdtTitle.isDisplayed()==true){
				if(addToCartbtn.isEnabled()==true){
					
				}
				}
			} return true;
		
	}
		public  boolean pdtTitleText() {
			return pdtTitle.isDisplayed();
		}
	
			public  boolean addToCart() {
				return addToCartbtn.isDisplayed();
		
	}
			public void addProductToCart(){
				addToCartbtn.click();
				
			}
	
}
