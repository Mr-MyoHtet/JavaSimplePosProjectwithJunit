package com.myohtet.spring.pos.service;

import java.time.LocalDate;
import java.util.List;

import com.myohtet.spring.pos.domain.input.ShoppingCart;
import com.myohtet.spring.pos.domain.output.SaleDetails;
import com.myohtet.spring.pos.domain.output.SaleInfo;

public interface SaleService {
	
	int checkOut(ShoppingCart cart);
	
	List<SaleInfo> search(String salePerson,LocalDate from,LocalDate To);
	
	SaleDetails findById(int id);

}
