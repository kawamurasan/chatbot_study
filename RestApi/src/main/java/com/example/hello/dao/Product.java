package com.example.hello.dao;

import javax.validation.constraints.NotBlank;

public class Product {
	  @NotBlank
	  private String id;

	  @NotBlank
	  private String name;

	  private int price;

	  public Product() {}

	  public Product(String id, String name, int price) {
	    this.setId(id);
	    this.setName(name);
	    this.setPrice(price);
	  }

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
