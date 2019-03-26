package com.planittesting.jupitertoys.model.products;

public class CompareByPrice implements CompareProduct {

	private double price;

	public  CompareByPrice(double price) {

		this.price = price;
	}

	@Override
	public boolean compare(Product product) {
		return product.getPrice()==price;
	}

}
