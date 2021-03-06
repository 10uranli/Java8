package com.tutorial.example.lambda;

import java.util.logging.Logger;

public class CalculatorWithLambda {

	private static Logger log = Logger.getLogger(Class.class.getName());
	
	public static void main(String[] args) {
		
		log.info("Aşağıdakilerden herhangi biri kullanılabilir.");
		Maths add = (int a, int b) -> a + b;
		Maths subtraction = (a, b) -> a - b;
		Maths multi = (a, b) -> {return a*b;}; // return için süslü parantez ve ; unutulmamalı.
		Maths div = (int a, int b) -> a/b;
		
		System.out.println("Add 5 + 10 = " + process(5, 10, add));
	}
	
	interface Maths{
		int allMaths(int a, int b);
	}
	
	private static int process(int a, int b, Maths operation) {
		
		return operation.allMaths(a, b);
	}
}
