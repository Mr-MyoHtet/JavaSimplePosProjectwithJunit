package com.myohtet.spring.pos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myohtet.spring.pos.domain.exceptions.PosBusinessException;
import com.myohtet.spring.pos.domain.output.ProductDto;


@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	void test_error_no_code() {
		var exception = assertThrows(PosBusinessException.class, () -> productService.findByCode(null));
		assertEquals("Please enter code!!!", exception.getMessage());
	}

	@ParameterizedTest
	@ValueSource(strings = { "P00001", "P0011", "P00008" })
	void test_error_invalid_code(String code) {
		var exception = assertThrows(PosBusinessException.class, () -> productService.findByCode(code));

		assertEquals("Invalid Product Code", exception.getMessage());

	}

	@ParameterizedTest
	@CsvSource({ "P0001,Egg L Size,500", "P0002,Egg M Size,400", "P0003,Egg S Size,350", "P0004,Patotos Chips,1200",
			"P0005,Coke 350 ML,800", "P0006,Coke 500 ML,1500" })
	void test_found(String code, String name, int price) {
		ProductDto result = productService.findByCode(code);
          assertNotNull(result);
          assertEquals(code, result.getCode());
          assertEquals(name, result.getName());
          assertEquals(price, result.getPrice());
	}

}
