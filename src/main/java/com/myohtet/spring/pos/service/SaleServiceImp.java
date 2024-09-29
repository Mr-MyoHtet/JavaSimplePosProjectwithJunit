package com.myohtet.spring.pos.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.myohtet.spring.pos.domain.exceptions.PosBusinessException;
import com.myohtet.spring.pos.domain.input.ShoppingCart;
import com.myohtet.spring.pos.domain.output.SaleDetails;
import com.myohtet.spring.pos.domain.output.SaleInfo;
import com.myohtet.spring.pos.repo.SaleHistoryRepo;
import com.myohtet.spring.pos.repo.SaleProductRepo;

@Service
public class SaleServiceImp implements SaleService {

	@Autowired
	private SaleHistoryRepo saleHistoryRepo;
	private SaleProductRepo saleProductRepo;

	@Override
	public int checkOut(ShoppingCart cart) {

		// create validation

		validate(cart);

		// create sale history

		var saleId = saleHistoryRepo.create(cart.getSalePerson());

		// sale_product join tow table
		for (var item : cart.getItems()) {
			saleProductRepo.create(saleId, item);
		}
		return saleId;
	}

	private void validate(ShoppingCart cart) {
		if (cart == null) {
			throw new PosBusinessException("Cart must not be null");

		}
		if (!StringUtils.hasLength(cart.getSalePerson())) {
			throw new PosBusinessException("Please Enter sale person name");

		}
		if (cart.getItems() == null || cart.getItems().isEmpty()) {

			throw new PosBusinessException("Please Enter sale items");

		}
		for (var item : cart.getItems()) {
			if (item == null) {
				throw new PosBusinessException("Please Enter items");

			}
			if (!StringUtils.hasLength(item.getProductCode())) {
				throw new PosBusinessException("Please Enter Product Code");

			}
			if (item.getQuantity() < 0) {
				throw new PosBusinessException("Please Enter Quantity");

			}
			if (item.getUnitPrice() < 0) {
				throw new PosBusinessException("Please Enter Unit Price");

			}
		}
	}

	@Override
	public List<SaleInfo> search(String salePerson, LocalDate from, LocalDate to) {
		
		return saleHistoryRepo.search(salePerson,from,to);
	}

	@Override
	public SaleDetails findById(int id) {
		var saleInfo = saleHistoryRepo.findById(id).orElseThrow(()->new PosBusinessException("Invalid sale id"));
		var items =saleProductRepo.findBySaleId(id);
		
		return SaleDetails.from(saleInfo,items);
	}

}
