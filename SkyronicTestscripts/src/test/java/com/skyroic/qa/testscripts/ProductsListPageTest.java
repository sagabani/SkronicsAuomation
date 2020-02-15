package com.skyroic.qa.testscripts;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
	
	@BeforeClass
	
	public void setUp(){
		initialization();
		pdtDetailsPage =new ProductDetailsPage();
		pdtListPage =new ProductsListPage();		
	}
	
/*	//@Test (priority=1)
	//Test to verify if pdt shows in exact order
	public void sortProductValidateTest(){
		boolean flag= pdtListPage.sortProductValidate(driver);
		Assert.assertTrue(flag);
		
	} */
	
	@Test (priority=1)
	 //Test To click on Ipad 4 Mini and to verify product details
	public void clickIpad4MiniTest(){
		pdtListPage.clickIpad4Mini();
		boolean flag = pdtDetailsPage.inStockDetails();
		Assert.assertTrue(flag);
		//pdtDetailsPage.addProductToCart();
		
	}
	
	@Test (priority=2)
	 //Test To verify add to cart and to check the cart header
	public void toAddpdtToCartTest(){
		//pdtListPage.clickIpad4Mini();
		boolean flag = pdtDetailsPage.addProductToCart();
		Assert.assertTrue(flag);
	}
	
	 @Test (priority=3)
	 //Test To verify out of stock
	public void inStockDetailsTest(){
		boolean flag =pdtDetailsPage.checkProductstock();
		Assert.assertTrue(flag);
	} 
	
	@AfterClass
	
	public void tearDown() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
		
	}


