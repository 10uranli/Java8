package com.tutorial.example.lesson1;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

public class Customer {

	
	public Customer(String name, List<Account> accounts) {
		super();
		this.name = name;
		this.accounts = accounts;
	}
	
	private String name;
	private List<Account> accounts;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public Account getAccountByAccountName_old(String name) {
		for (Account account : accounts) {
			if(account.getName().equals(name)) {
				return account;
			}
		}
		return null;
	}
	
	public Optional<Account> getAccountByAccountName_new(String name) {
		for (Account account : accounts) {
			if(account.getName().equals(name)) {
				return Optional.of(account) ;
			}
		}
		return Optional.empty();
	}
	
	public double getBalance_old() {
		double totalBalance = 0.0;
		for (Account account : accounts) {
			totalBalance += account.getBalance();
		}
		return totalBalance;
	}
	
	public double getBalance_new() {
//		ToDoubleFunction<? super Account> mapper = account -> account.getBalance();
		//alt+shift/l
		ToDoubleFunction<? super Account> mapper = Account :: getBalance;//referans method
		return 	accounts.stream().mapToDouble(mapper).sum();
		/*stream ile hesaplarin aktigini dusunebiliriz.Map ile sadece hesaplarin bakiyeleri akar.sum ile bunlari toplariz*/
	}
	
	public double getBalance_withmap() {
		//map'e cevirince obje stream turune doner
		return 	accounts.stream().map(Account :: getBalance).reduce(0,(s,b)->s+b);
	}
	
	public double getBalance_withfilter() {
		//14000 bin fazlasi akmaya devam eder
		return accounts.stream().filter(account -> account.getBalance() > 14000).mapToDouble(Account :: getBalance).sum();
	}
	
	public double getBalance_withmap_filter() {
		//14000 bin fazlasi akmaya devam eder.Reduce ile sonucu tek bir degere indirgiyor.Baslangic degeri 0 olup toplayarak tek sonuc uretir.
		// a = 0 balance =0 , a = 15000 balance = 15000, a = 20000, b = 35000. Yani kisaca ilk 0 ile baslar, a sirasiyla degerleri balance toplami tutar
		return accounts.stream().filter(account -> account.getBalance() > 14000).map(Account :: getBalance).reduce(0,(a,balance)->a+balance);
	}
	
	//cozumu paralellestirmek cok kolay
	//buyuk sorunlar icin yapilmali
	//okumasi sorunu bulmasi zorlasir
	public double getBalance_withmap_filter_paralel() {
		return accounts.stream().parallel().filter(account -> account.getBalance() > 14000).map(Account :: getBalance).reduce(0,(a,balance)->a+balance);
	}
	
}
