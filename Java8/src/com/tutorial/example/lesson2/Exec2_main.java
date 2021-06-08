package com.tutorial.example.lesson2;

public class Exec2_main {


	public static void main(String[] args) {
		int x = 50; // primitive type byte, short vs vs.
		String y = "onur"; //class--> string, reference variable
		
		//1.anonymous class
		//bu sinifta tek kopya , obje yeter bize baska kopyaya ihtiyac yok.Ondan isim vermiyorum.Anonymous class olur yani
		FuncInterface z0 = new FuncInterface() {
			@Override
			public int f(int x) {
				// TODO Auto-generated method stub
				return x*x;
			}
		};
		System.out.println(z0.f(4));
	}
	
	//2.Lambda expression. anonymous classin kisaltilmis hali
	FuncInterface z1 = (int u) -> {return u*u;};
	FuncInterface z2 = (u) -> {return u*u;};
	FuncInterface z3 = u -> {return u*u;};
	FuncInterface z4 = u ->  u*u;
	//signutureler match ediyor 
	//bir methodu artik referans edebiliyoruz
	//method referance
	FuncInterface z5 = Inner :: sum;
	Inner2 inner2 = new Inner2();
	FuncInterface z6 = inner2 :: div;
	
}

class  Inner{
	public static int sum(int y) {
		return y+y;
	}
}
class  Inner2{
	public  int div(int y) {
		return y/y;
	}
}
@FunctionalInterface
interface FuncInterface{
	int f(int x);//SAM  : Single Abstract Method functional kullanabilmek için 1 tane sam olmali
}
