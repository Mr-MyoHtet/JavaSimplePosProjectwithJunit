package com.myohtet.spring.pos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import com.myohtet.spring.pos.domain.input.ShoppingCart;

public class LearningparameterizedTest {

	@ParameterizedTest
	@NullSource
	void test_null_source(LocalDate date) {
		assertNull(date);

	}

	@ParameterizedTest
	@EmptySource
	void empty_source(List<String> list) {
		assertEquals(0, list.size());
	}

	@ParameterizedTest
	@NullAndEmptySource
	void null_and_empty_source(String str) {
		if (null == str) {
			assertNull(str);
		} else {
			assertEquals(0, str.length());
		}
	}

	@ParameterizedTest
	@EnumSource(value = DayOfWeek.class, names = { "SUNDAY", "SATURDAY", }, mode = Mode.EXCLUDE)
	void enum_source(DayOfWeek input) {
		// System.out.println(input);
	}

	@ParameterizedTest
	@MethodSource()
	// method source same name
	void method_source(String input) {
		System.out.println(input);
	}

	@ParameterizedTest
	@MethodSource("method_source")
	// method source different name
	void using_method_source_with_name(String input) {
		System.out.println(input);
	}

	// method source with external class
	@ParameterizedTest
	@MethodSource("com.myohtet.spring.pos.service.ShoppingCartProvider#provide")
	void using_external_method_source(ShoppingCart cart) {
		System.out.println(cart);
	}

	static Stream<String> method_source() {
		return Stream.iterate('A', a -> (char) (a.charValue() + 1)).limit(5).map(a -> a.toString());
	}

	// argumentsSource

	@ParameterizedTest
	@ArgumentsSource(value = ShoppingCartProvider.class)
	void using_argument_souruce(ShoppingCart cart) {
		System.out.println("Learning Argument Source");
		System.out.println(cart);
	}
	

	// try custom methodsorce from myo
	static int sumMethod(int a, int b) {
		return a + b;
	}

	@ParameterizedTest
	@MethodSource
	void sum_method_source(int input, int output,int expected) {
     assertEquals(expected, sumMethod(input, output));
     System.out.println("Hello world");
     System.out.println("Good Morining");
	}

	static Stream<Arguments> sum_method_source() {
		return Stream.of(Arguments.of(1, 1, 2));
	}

}
