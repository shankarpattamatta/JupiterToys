package com.planittesting.jupitertoys.model.products;

public class CompareByTitle implements CompareProduct {

	private String title;

	public CompareByTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean compare(Product p) {

		return p.getTitle().equals(title);
	}

}
