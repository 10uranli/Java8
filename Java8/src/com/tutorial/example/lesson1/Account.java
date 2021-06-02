package com.tutorial.example.lesson1;

import com.sun.org.glassfish.gmbal.AMXMetadata;

public class Account {

	private String name;
	private String iban;
//	private  Integer balance;
	protected Integer balance;//sub class erisebilsin diye.Yine obje dogrudan erisemez. hicbir sey yazmazsak default olur.package private.Ayni paketteki siniflar erisebilir.defaul protected benzer protected extend edende erisir 

	
	public Account(String name, String iban, Integer balance) {
		super();
		this.name = name;
		this.iban = iban;
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	
	public boolean withDraw(Integer amount) {
		if(amount<=0) return false;
		if(amount> this.balance) return false;
		this.balance = this.balance -amount;
		return true;
	}
	@Override
	public String toString() {
		return "Account [name=" + name + ", iban=" + iban + ", balance=" + balance + "]";
	}
	
}
