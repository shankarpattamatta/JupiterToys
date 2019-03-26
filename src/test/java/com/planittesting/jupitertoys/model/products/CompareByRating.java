package com.planittesting.jupitertoys.model.products;

public class CompareByRating implements CompareProduct {

	private int rating;

	public CompareByRating(int rating) {
		this.rating = rating;
	}

	@Override
	public boolean compare(Product product) {
		return product.getRating()==rating;

	}

}
