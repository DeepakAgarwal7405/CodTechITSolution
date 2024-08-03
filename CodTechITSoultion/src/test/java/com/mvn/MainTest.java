package com.mvn;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.browser.BrowserConfiguration;
import com.google.common.io.Files;
import com.model.AddProduct;
import com.model.AddToCart;
import com.model.LoginPages;
import com.model.LogoutOption;
import com.model.SideMenu;

public class MainTest 
{
	WebDriver driver=null;
	LoginPages lp=null;
	SideMenu s1=null;
	AddToCart a1 =null;
	LogoutOption lo=null;
	AddProduct ap=null;
	
	
	
	@BeforeClass
	public void loadBrowser() throws InterruptedException
	{
//		
		driver=new BrowserConfiguration().ChromeBrowserSelection("chrome", "https://www.saucedemo.com/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@BeforeMethod
	public void beforetest()
	{
		lp=new LoginPages();
		s1=new SideMenu();
		a1=new AddToCart();
		lo=new LogoutOption();
		ap=new AddProduct();
	}
	@Test(priority = 0,dataProvider = "deepak")
	public void loginDetails(String uname,String pass) throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.id("user-name")).clear();
		driver.findElement(By.id("user-name")).sendKeys(uname);
		Thread.sleep(2000);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pass);
		Thread.sleep(2000);
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(3000);
	
	
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"))
		{
			System.out.println("Your Login Test Has been Passed...");
			System.out.println("Username :- "+uname);
			System.out.println("Password :- "+pass);
		}
		else
		{
			System.out.println("Your Login Test Hasbeen Failed.:- \n");
			System.out.println("Username :- "+uname);
			System.out.println("Password :- "+pass);
			
			WebElement erroruser=driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
			System.out.println(erroruser.getText());

			
			File file=((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(file,new File("Screenshot\\LoginFailed.jpg"));
			Thread.sleep(2000);
	//		fail("Login Failed");
			driver.close();
		}
			
		s1.openSideMenu(driver);
		s1.openAllItem(driver);
		ap.Addprod(driver);
		s1.openAbout(driver);
		driver.navigate().back();
		Thread.sleep(2000);
		s1.openResetAppState(driver);
		s1.closeSideMenu(driver);
		
		
		driver.navigate().refresh();
		ap.Addprod(driver);
		a1.addtocartlogo(driver);
		a1.Checkoutpage(driver);
		a1.Checkoutoverview(driver);
		driver.navigate().back();
		
		
		s1.openSideMenu(driver);
		lo.ClickLogout(driver);
	
	
	
	}
	
	@DataProvider(name="deepak")
	public String[][] data() throws InvalidFormatException, IOException
	{
		String[][] data = LoginPages.readData();
//		
		
		return data;
	}
	

	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("Bye Bye...");
		Thread.sleep(3000);
		driver.close();		
	}
}
