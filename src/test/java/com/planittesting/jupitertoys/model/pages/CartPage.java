package com.planittesting.jupitertoys.model.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.planittesting.jupitertoys.model.dialouges.RemoveItemDialouge;
import com.planittesting.jupitertoys.model.table.Table;

public class CartPage extends BasePage {

	Table table;

	public CartPage(WebDriver driver) {
		super(driver);
		table = new Table(driver.findElement(By.className("cart-items")));
	}

	public double getPrice(String title) throws Exception {
		return Double.parseDouble(table.getValue("Item", "Price", title).getText().replace("$", ""));
	}

	public int getQuantity(String title) throws Exception {
		return Integer.parseInt(
				table.getValue("Item", "Quantity", title).findElement(By.tagName("input")).getAttribute("value"));
	}

	public double getSubTotal(String title) throws Exception {
		return Double.parseDouble(table.getValue("Item", "Subtotal", title).getText().replace("$", ""));
	}

	public double getTotal() {
		return Double.parseDouble(driver.findElement(By.className("total")).getText().replace("Total: ", ""));

	}

	public RemoveItemDialouge clickRemoveButton(String title) throws Exception {

		table.getValue("Item", "Actions", title).findElement(By.className("remove-item")).click();
		return new RemoveItemDialouge(driver.findElement(By.className("popup")));
		
	}
}
