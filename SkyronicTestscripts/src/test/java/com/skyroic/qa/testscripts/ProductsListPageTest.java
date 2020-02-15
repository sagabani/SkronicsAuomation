package com.skyroic.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.skyronic.qa.base.TestBase;
import com.skyronic.qa.pages.ProductDetailsPage;
import com.skyronic.qa.pages.ProductsListPage;

public class ProductsListPageTest extends TestBase {
	
	ProductDetailsPage pdtDetailsPage;
	ProductsListPage pdtListPage;
	
	public ProductsListPageTest(){
		super();
	}
	
	@BeforeMethod
	
	public void setUp(){
		initialization();
		pdtDetailsPage =new ProductDetailsPage();
		pdtListPage =new ProductsListPage();
		
		
	}
	
	
	//@Test (priority=1)
	
	public void sortProductValidateTest(){
		boolean flag= pdtListPage.sortProductValidate(driver);
		Assert.assertTrue(flag);
		
	}
	
	//@Test (priority=2)
	 
	public void clickIpad4MiniTest(){
		pdtListPage.clickIpad4Mini();
		
	}
	
	@Test (priority=3)
	 
	public void inStockDetailsTest(){
		boolean flag =pdtDetailsPage.inStockDetails();
		Assert.assertTrue(flag);
		pdtDetailsPage.addProductToCart();
		
		
		
		
	}
	
	
	
	
	@AfterMethod
	
	public void tearDown(){
		//driver.quit();
	}
		
	}


