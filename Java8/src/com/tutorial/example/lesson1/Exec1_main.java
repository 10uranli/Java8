package com.tutorial.example.lesson1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Exec1_main {

	private static Customer onur;
	static {

		List<Account> accountList = new ArrayList<Account>();
		Account account1 = new Account("Acn1", "TR0001", 10000);
		Account account2 = new Account("Acn2", "TR0002", 15000);
		Account account3 = new Account("Acn3", "TR0003", 20000);
		accountList.add(account1);
		accountList.add(account2);
		accountList.add(account3);
		onur = new Customer("Onur", accountList);

	}

	public static void main(String[] args) {
		
		System.out.println("***old***");
		/**eski yöntem*/
		System.out.println(onur.getAccountByAccountName_old("Acn1"));
		//Account [name=Acn1, iban=TR0001, balance=10000]
		System.out.println(onur.getAccountByAccountName_old("Olmayan_Hesap"));
		//null
		//System.out.println(onur.getAccountByAccountName_old("Olmayan_Hesap").getIban());
		//null pointer exception
		
		System.out.println("***new***");
		
		/**yeni yöntem*/
		System.out.println(onur.getAccountByAccountName_new("Acn1"));
		//Optional[Account [name=Acn1, iban=TR0001, balance=10000]]

		System.out.println(onur.getAccountByAccountName_new("Olmayan_Hesap"));
		//Optional.empty

		onur.getAccountByAccountName_new("Acn2").ifPresent(account -> System.out.println(account.getIban()));
		//TR0002
		
		onur.getAccountByAccountName_new("Olmayan_Hesap").ifPresent(account -> System.out.println(account.getIban()));
		//if Present ile gelmedigi için null pointer vs almaz
		
		/**hesaptan para cekelim*/
		System.out.println("***withdraw***");
		
		Optional<Account> acn1 = onur.getAccountByAccountName_new("Acn1");
		if(acn1.isPresent()){
			acn1.get().withDraw(1000);
			System.out.println("Daha klasik yöntemle" + acn1.get());
			//Daha klasik yöntemleAccount [name=Acn1, iban=TR0001, balance=9000]

		}
		
		Consumer<? super Account> withDraw = account -> account.withDraw(1000);
		Consumer<? super Account> printAccount = withDraw.andThen(account -> System.out.println("Daha yeni yöntem: " + account));
		//Daha yeni yöntem: Account [name=Acn1, iban=TR0001, balance=8000]
//		Consumer<? super Account> printAccount = withDraw.andThen(System.out::println); //parametre almaya baslarsa yapilamiyor

		onur.getAccountByAccountName_new("Acn1").ifPresent(printAccount);
		
		/**Toplam bakiye*/
		System.out.println("***balance***");
		System.out.println("Old : " + onur.getBalance_old());
		System.out.println("new : " + onur.getBalance_new());
		System.out.println("reduce : " + onur.getBalance_withmap());
		System.out.println("filter: " + onur.getBalance_withfilter());
		System.out.println("map_filter: " + onur.getBalance_withmap_filter());
		System.out.println("paralel_map_filter: " + onur.getBalance_withmap_filter_paralel());
//		***balance***
//		Old : 43000.0
//		new : 43000.0
//		reduce : 43000.0
//		filter: 35000.0
//		map_filter: 35000.0
//		paralel_map_filter: 35000.0


	}

}
