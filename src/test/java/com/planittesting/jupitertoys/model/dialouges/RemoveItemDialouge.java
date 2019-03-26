package com.planittesting.jupitertoys.model.dialouges;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RemoveItemDialouge {
	private WebElement rootElement;

	public RemoveItemDialouge(WebElement rootElement) {
		this.rootElement = rootElement;

	}
	
	public void clickYes()
	{
		rootElement.findElement(By.className("btn-success")).click();
	}
	
	public void clickNo()
	{
		rootElement.findElement(By.className("btn-cancel")).click();
	}
}
