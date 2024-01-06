package com.ratanaphoneshop.phoneshop.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.ratanaphoneshop.phoneshop.utils.GeneralUtils;

public class GeneralUtilTest {

	@Test
	public void testTointegerList() {
		// Given
		List<String> names = List.of("dara","ratana","thida");
		
		// When
		List<Integer> integerList = GeneralUtils.toIntegerList(names);
		
		//then [4,6,5]
		assertEquals(3, integerList.size());
		assertEquals(4, integerList.get(0));
		assertEquals(6, integerList.get(1));
		assertEquals(5, integerList.get(2));
	}
	
	@Test
	public void testevennumber() {
		// Given
		List<Integer> number = List.of(1,2,3,4,5,6,50);
		
		// When
		List<Integer> evenNumber = GeneralUtils.EvenNumber(number);
		
		// then [2,4,6,50]
		assertEquals(4, evenNumber.size());
		assertEquals(4, evenNumber.get(1));
	}
}
