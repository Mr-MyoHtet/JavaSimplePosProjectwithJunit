package com.myohtet.spring.pos.repo;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myohtet.spring.pos.domain.output.ProductDto;

@Repository
public class ProductRepoImp implements ProductRepo {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private RowMapper<ProductDto> rowMapper = new DataClassRowMapper<>(ProductDto.class);

	@Override
	public Optional<ProductDto> findByCode(String code) {

		return template.query("select * from PRODUCT where code =:code", Map.of("code", code), rowMapper).stream()
				.findAny();
	}

}
