package com.planittesting.jupitertoys.model.dialouges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogoutDialouge {

	private WebElement rootElement;

	public LogoutDialouge(WebElement rootElement) {
		this.rootElement = rootElement;

	}

	public void clickLogout()
	{
		rootElement.findElement(By.className("btn-success")).click();
	}
}
