package com.myohtet.spring.pos.service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import com.myohtet.spring.pos.domain.input.SaleItem;
import com.myohtet.spring.pos.domain.input.ShoppingCart;



public class ShoppingCartProvider  implements ArgumentsProvider{
	
	public static Stream<Arguments> provide(){
		return Stream.of(
				Arguments.of(cartWithNoUserName()),
				Arguments.of(cartWithNoItems()),
				Arguments.of(cartWithOneItems())
				);
	}
	private static ShoppingCart cartWithNoUserName() {
		var cart = new ShoppingCart();
		cart.setItems(new ArrayList<>());
		return cart;
	}
	
	private static ShoppingCart cartWithNoItems() {
		var cart = new ShoppingCart();
      cart.setSalePerson("Aung Aung");
		return cart;
	}
	
	private static Object cartWithOneItems() {
		var cart = new ShoppingCart();
		var items = new SaleItem();
		items.setProductCode("P0001");
		items.setQuantity(3);
		items.setUnitPrice(1000);
		cart.setSalePerson("Myo");
		cart.setItems(List.of(items));
		return cart;
	}
	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		// TODO Auto-generated method stub
		return provide();
	}



}
