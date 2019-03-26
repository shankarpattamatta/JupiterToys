package com.planittesting.jupitertoys.model.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.planittesting.jupitertoys.model.products.CompareProduct;
import com.planittesting.jupitertoys.model.products.Product;

public class ShoppingPage extends BasePage {

	public ShoppingPage(WebDriver driver) {
		super(driver);
	}

	public Product getProduct(CompareProduct strategy) throws Exception {

		List<WebElement> productsList = driver.findElements(By.className("product"));
		for (WebElement productItem : productsList) {
			Product product = new Product(productItem);
			if (strategy.compare(product)) {
				return product;
			}
		}
		throw new Exception("Product Not Found Exception");

	}

	

}
