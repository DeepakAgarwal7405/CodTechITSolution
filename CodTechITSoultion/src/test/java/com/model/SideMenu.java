package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideMenu
{
	public void openSideMenu(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
	}
	public void openAllItem(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("inventory_sidebar_link")).click();
		Thread.sleep(2000);
	}
	public void openAbout(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("about_sidebar_link")).click();
		Thread.sleep(2000);
	}
	public void openResetAppState(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("react-burger-menu-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("reset_sidebar_link")).click();
		Thread.sleep(2000);
	}
	public void closeSideMenu(WebDriver driver) throws InterruptedException
	{
		driver.findElement(By.id("react-burger-cross-btn")).click();
		Thread.sleep(2000);
	}
}
