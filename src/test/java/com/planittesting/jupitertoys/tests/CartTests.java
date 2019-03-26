package com.planittesting.jupitertoys.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.planittesting.jupitertoys.model.dialouges.RemoveItemDialouge;
import com.planittesting.jupitertoys.model.pages.CartPage;
import com.planittesting.jupitertoys.model.pages.HomePage;
import com.planittesting.jupitertoys.model.pages.ShoppingPage;
import com.planittesting.jupitertoys.model.products.CompareByTitle;
import com.planittesting.jupitertoys.model.products.Product;

public class CartTests extends BaseTests {

	@Test
	public void compareProductPrice() throws Exception {
		HomePage homePage = new HomePage(driver);
		ShoppingPage shoppingPage = homePage.clickShopMenu();
		Product product = shoppingPage.getProduct(new CompareByTitle("Fluffy Bunny"));
		double productPrice = product.getPrice();
		product.clickBuy();
		CartPage cartPage = homePage.clickCart();
		assertEquals(productPrice, cartPage.getPrice("Fluffy Bunny"));
	}

	@Test
	public void validateSubtotalcalc() throws Exception {
		String[] productTitles = { "Fluffy Bunny", "Stuffed Frog", "Handmade Doll" };
		double calcSubTotal=0.0;
		HomePage homePage = new HomePage(driver);
		ShoppingPage shoppingPage = homePage.clickShopMenu();
		for (String productTitle : productTitles) {
			Product product = shoppingPage.getProduct(new CompareByTitle(productTitle));
			product.clickBuy();
			product.clickBuy();
			product.clickBuy();
		}
		CartPage cartPage = shoppingPage.clickCart();

		for (String productTitle : productTitles) {
			calcSubTotal=cartPage.getQuantity(productTitle)*cartPage.getPrice(productTitle);
			assertEquals(calcSubTotal, cartPage.getSubTotal(productTitle));
		}

	}

	@Test
	public void validateProductSubTotals() throws Exception {
		String[] productTitles = { "Fluffy Bunny", "Stuffed Frog", "Handmade Doll" };
		double subTotalSum = 0.0;
		HomePage homePage = new HomePage(driver);
		ShoppingPage shoppingPage = homePage.clickShopMenu();
		for (String productTitle : productTitles) {
			Product product = shoppingPage.getProduct(new CompareByTitle(productTitle));
			product.clickBuy();
			product.clickBuy();
			product.clickBuy();
		}
		CartPage cartPage = shoppingPage.clickCart();
		for (String productTitle : productTitles) {
			subTotalSum = subTotalSum + cartPage.getSubTotal(productTitle);
		}
		assertEquals(subTotalSum, cartPage.getTotal());

	}

	@Test
	public void compareTotalAfterProductremoval() throws Exception {
		String[] productTitles = { "Fluffy Bunny", "Stuffed Frog", "Handmade Doll" };
		
		HomePage homePage = new HomePage(driver);
		ShoppingPage shoppingPage = homePage.clickShopMenu();
		for (String productTitle : productTitles) {
			Product product = shoppingPage.getProduct(new CompareByTitle(productTitle));
			product.clickBuy().clickBuy().clickBuy();
		}
		CartPage cartPage = shoppingPage.clickCart();
		double totalBeforeRemoval=cartPage.getTotal();
		double subTotal=cartPage.getSubTotal(productTitles[0]);
		RemoveItemDialouge removeItemDialouge = cartPage.clickRemoveButton(productTitles[0]);
		removeItemDialouge.clickYes();
		assertEquals(cartPage.getTotal(),totalBeforeRemoval-subTotal);
		
	}

}
