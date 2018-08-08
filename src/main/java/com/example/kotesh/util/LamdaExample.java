package com.example.kotesh.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LamdaExample {
	
	public static void main(String[] args) {
		Map<Integer, String> testMap = new HashMap<Integer, String>();
		for(int i=0;i<10;i++) {
			testMap.put(i+1,"Value #"+i);
		}
		List<Integer> keys = testMap.keySet().stream().collect(Collectors.toList());
		
		List<String> values = testMap.values().stream().collect(Collectors.toList());
		
		System.out.println("Keys are "+keys);
		System.out.println("Values are "+values);
		
		List<Integer> keys1 = new ArrayList<>(testMap.keySet());
		List<String> values1 = new ArrayList<>(testMap.values());
		
		System.out.println("Keys are "+keys1);
		System.out.println("Values are "+values1);
		
		keys = testMap.keySet().stream().filter(x->1!=x).collect(Collectors.toList());
		System.out.println(keys);
	}

}
