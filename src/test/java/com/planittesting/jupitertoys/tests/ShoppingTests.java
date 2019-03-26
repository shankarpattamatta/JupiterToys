package com.planittesting.jupitertoys.tests;

import org.junit.jupiter.api.Test;

import com.planittesting.jupitertoys.model.pages.CartPage;
import com.planittesting.jupitertoys.model.pages.HomePage;
import com.planittesting.jupitertoys.model.pages.ShoppingPage;
import com.planittesting.jupitertoys.model.products.CompareByPrice;
import com.planittesting.jupitertoys.model.products.CompareByRating;
import com.planittesting.jupitertoys.model.products.CompareByTitle;
import com.planittesting.jupitertoys.model.products.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingTests extends BaseTests {

	@Test
	public void validateproductRate() throws Exception {

		HomePage homePage = new HomePage(driver);
		ShoppingPage shoppingPage = homePage.clickShopMenu();

		Product product = shoppingPage
				.getProduct(p -> p.getTitle().startsWith("T") && p.getPrice() > 9 && p.getPrice() < 11);

		assertEquals(12.99, product.getPrice(), 0.001);
	}

	// click buy on a product that costs 9.99

	@Test
	public void buyProduct() throws Exception {
		HomePage homePage = new HomePage(driver);
		ShoppingPage shoppingPage = homePage.clickShopMenu();
		Product product = shoppingPage.getProduct(new CompareByPrice(9.99));
		product.clickBuy();
		// shoppingPage.getCartCount();

	}

	@Test
	public void buyFiveStarProduct() throws Exception {
		HomePage homePage = new HomePage(driver);
		ShoppingPage shoppingPage = homePage.clickShopMenu();
		Product product = shoppingPage.getProduct(new CompareByRating(5));
		product.clickBuy();
	}

	@Test
	public void buyGenericProduct() throws Exception {
		HomePage homePage = new HomePage(driver);
		ShoppingPage shoppingPage = homePage.clickShopMenu();
		Product product = shoppingPage.getProduct(p -> p.getRating() > 3 && p.getPrice() < 9.50);
		product.clickBuy();

	}

	
}
