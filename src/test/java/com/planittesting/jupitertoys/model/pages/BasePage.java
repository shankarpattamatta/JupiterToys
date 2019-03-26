package com.planittesting.jupitertoys.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planittesting.jupitertoys.model.dialouges.LoginDialouge;
import com.planittesting.jupitertoys.model.dialouges.LogoutDialouge;

public abstract class BasePage {
//This has common code across all page objects ,
//As driver object is constant across all page objects , we have added the driver object here 
//Also In order to mandate using objects across all the pages, we have used abstract keyword.	

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	public String getUserName() {

		return driver.findElement(By.className("user")).getText();
	}

	public LoginDialouge clickLogin() {

		driver.findElement(By.cssSelector("#nav-login a")).click();
		return new LoginDialouge(driver.findElement(By.className("popup")));
	}
	
	public void clickContactPage()
	{
		driver.findElement(By.cssSelector("#nav-contact a")).click();
	}
	
	public ShoppingPage clickShopMenu() {
		
		driver.findElement(By.cssSelector("#nav-shop a")).click();
		return new ShoppingPage(driver);
		//return new Product(driver.findElements(By.className("products")))
		
	}

	
	public LogoutDialouge clickLogout() {
		
		driver.findElement(By.cssSelector("#nav-logout a")).click();
		return new LogoutDialouge(driver.findElement(By.className("popup")));
		
	}
	
	public CartPage clickCart()
	{
		driver.findElement(By.cssSelector("#nav-cart a")).click();
		return new CartPage(driver);
		
	}
}