package com.myohtet.spring.pos.domain.input;

import java.util.List;

import lombok.Data;

public class ShoppingCart {

	private String salePerson;

	private List<SaleItem> items;

	public String getSalePerson() {
		return salePerson;
	}

	public void setSalePerson(String salePerson) {
		this.salePerson = salePerson;
	}

	public List<SaleItem> getItems() {
		return items;
	}

	public void setItems(List<SaleItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ShoppingCart [salePerson=" + salePerson + ", items=" + items + "]";
	}
	
	

}
