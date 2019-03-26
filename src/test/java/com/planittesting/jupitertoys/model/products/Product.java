package com.planittesting.jupitertoys.model.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.planittesting.jupitertoys.model.pages.CartPage;

public class Product {

	private WebElement rootElement;

	public Product(WebElement rootElement) {

		this.rootElement = rootElement;
	}

	public String getTitle() {
		return rootElement.findElement(By.className("product-title")).getText();
	}

	public double getPrice() {

		return Double.parseDouble(rootElement.findElement(By.className("product-price")).getText().replace("$", ""));
	}
	
	public int getRating() {
		return Integer.parseInt(rootElement.findElement(By.className("star-level")).getText());
		
	}

	public Product clickBuy() {
		
		rootElement.findElement(By.className("btn-success")).click();
		return this;
	}

	
}
