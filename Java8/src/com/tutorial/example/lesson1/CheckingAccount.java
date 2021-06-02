package com.tutorial.example.lesson1;

import com.sun.org.glassfish.gmbal.AMXMetadata;

//CheckingAccount sub/derived class
//Account super class/base class
public class CheckingAccount  extends Account{
	
	
	private double overdraftAmount;//bakiyede olmasa bile alabilecegi kredi

	public CheckingAccount(String name, String iban, Integer balance, double overdraftAmount) {
		super(name, iban, balance);//super class/base class eger bos constructor olsa buna gerek olmayackti
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	public void setOverdraftAmount(double overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}

	@Override
	public boolean withDraw(Integer amount) {
		
		if(amount <= 0) return false;
		
		if(amount > (balance + overdraftAmount)) return false; //balance protected oldugundan erisebildik
		
		balance -= amount;
		
		return true;
		
		
	}
	
	


}
