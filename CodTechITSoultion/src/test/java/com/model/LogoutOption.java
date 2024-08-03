package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutOption {
	
	public void ClickLogout(WebDriver driver) throws InterruptedException {
//		Thread.sleep(1500);
//		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		
		Thread.sleep(1500);
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}
