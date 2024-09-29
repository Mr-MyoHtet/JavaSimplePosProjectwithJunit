package com.myohtet.spring.pos.repo;

import java.util.List;

import com.myohtet.spring.pos.domain.input.SaleItem;
import com.myohtet.spring.pos.domain.output.SaleDetailsItem;

public interface SaleProductRepo {


	List<SaleDetailsItem> findBySaleId(int id);

	void create(int saleId, SaleItem item);

}
