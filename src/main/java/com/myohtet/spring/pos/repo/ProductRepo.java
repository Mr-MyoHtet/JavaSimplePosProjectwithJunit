package com.myohtet.spring.pos.repo;

import java.util.Optional;

import com.myohtet.spring.pos.domain.output.ProductDto;

public interface ProductRepo {

	Optional<ProductDto> findByCode(String code);

}
