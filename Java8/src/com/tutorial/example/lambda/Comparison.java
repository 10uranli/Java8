package com.tutorial.example.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

//lesson 1 
public class Comparison {

	private final static Logger log = Logger.getLogger(Comparison.class.getName());

	public static void main(String[] args) {
		log.info("Main exe started...");

		log.info("two lists created.");
		List<String> teamList = new ArrayList<String>();
		teamList.add("Gs");
		teamList.add("Fb");
		teamList.add("Bjk");
		teamList.add("Ts");

		List<String> teamList1 = new ArrayList<String>();
		teamList1.add("Gs");
		teamList1.add("Fb");
		teamList1.add("Bjk");
		teamList1.add("Ts");
		log.info("two lists created.");
		
		sortWithJava7(teamList); 
		System.out.println(teamList);
		log.info("**********************************");
		sortWithJava8(teamList1);
		System.out.println(teamList1);

	}

	private static void sortWithJava7(List<String> teamList) {
		log.info("Sort using java 7 started");
		Collections.sort(teamList, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}

		});

		log.info("Sort using java 7 ended");
	}

	private static void sortWithJava8(List<String> teamList) {
		log.info("Sort using java 8 started");
		Collections.sort(teamList, (o1, o2) -> o1.compareTo(o2));
		log.info("Sort using java 8 ended");
	}
}
