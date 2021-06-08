package com.tutorial.example.lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import com.tutorial.example.lesson1.Account;

public class Exec3_main {
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);list.add(2);
		list.add(3);list.add(4);	
		
		Predicate<? super Integer> isEven = n -> n%2==0;
		Function<? super Integer, ? extends Integer> div2 = n -> n/2;
		list.stream().filter(isEven).map(div2).forEach(System.out :: println);;
	
		//stream: veriler akar
		//filter : filtrelenmis veriler akar
		//map : datayi yakalar islem yapar map(Account :: getBalance) sadece aksin yada artik *2 si aksin gibi
		//reduce : degeri teke indirgeme
	}

}
