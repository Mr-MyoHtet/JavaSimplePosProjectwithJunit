package com.myohtet.spring.pos.service;

import com.myohtet.spring.pos.domain.output.ProductDto;

public interface ProductService {
	
	ProductDto findByCode(String code);

}
