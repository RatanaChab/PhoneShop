package com.ratanaphoneshop.phoneshop.utils;

import java.util.List;

public class GeneralUtils {
	
	public static List<Integer> toIntegerList(List<String> list){
		
		return list.stream().map(s -> s.length()).toList();
	}
	
	public static List<Integer> EvenNumber(List<Integer> list){
		return list.stream().filter(x -> x%2 == 0).toList();
	}
}
