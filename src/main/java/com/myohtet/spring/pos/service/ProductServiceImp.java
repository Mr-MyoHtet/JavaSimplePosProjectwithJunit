package com.myohtet.spring.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.myohtet.spring.pos.domain.exceptions.PosBusinessException;
import com.myohtet.spring.pos.domain.output.ProductDto;
import com.myohtet.spring.pos.repo.ProductRepo;

@Service
public class ProductServiceImp implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public ProductDto findByCode(String code) {

		if (!StringUtils.hasLength(code)) {
			throw new PosBusinessException("Please enter code!!!");
		}
		
		return productRepo.findByCode(code).orElseThrow(() -> new PosBusinessException("Invalid Product Code"));
	}

}
