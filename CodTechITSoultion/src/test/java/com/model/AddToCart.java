package com.model;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.io.Files;

public class AddToCart 
{
	public void addtocartlogo(WebDriver driver) throws Exception
	{
//		AddProduct.Addprod(driver);
//		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
//		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(2000);
		

		
		
	}
	
	public void Checkoutpage(WebDriver driver) throws Exception {
		
		driver.findElement(By.id("first-name")).sendKeys("Don432");
		Thread.sleep(1000);
		driver.findElement(By.id("last-name")).sendKeys("Don");
		Thread.sleep(1000);
		driver.findElement(By.id("postal-code")).sendKeys("585475");
		Thread.sleep(2000);
		driver.findElement(By.id("continue")).click();
		
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-step-two.html"))
		{
			
		}
		else {
			WebElement errorcheckout=driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3"));
			System.out.println(errorcheckout.getText());
			
			driver.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("reset_sidebar_link")).click();
			Thread.sleep(2000);
			
//			driver.findElement(By.id("react-burger-menu-btn")).click();
//			Thread.sleep(2000);
			driver.findElement(By.id("logout_sidebar_link")).click();
			Thread.sleep(1000);

		}
		
	}
	
	public void Checkoutoverview(WebDriver driver) throws Exception {
		
		File file=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file,new File("Screenshot\\Continue.jpg"));
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		
		try {
			driver.findElement(By.id("finish")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/checkout-complete.html"))
		{
			
		}
		else {
			
			driver.findElement(By.id("react-burger-menu-btn")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("reset_sidebar_link")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.id("logout_sidebar_link")).click();
			Thread.sleep(1000);

		}
		
		
		driver.findElement(By.id("back-to-products")).click();
		Thread.sleep(2000);
		
	}
}
