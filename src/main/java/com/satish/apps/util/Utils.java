package com.satish.apps.util;

import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	A a = new A();
	
	public String generateUserId() {
		return UUID.randomUUID().toString();
	}
	
	public static void main(String arg[]) {
		
		
		
		//a.print();
		
		Supplier<String> s = () -> {
			A a = new A();
			a.print();
			return "Satish";
		};
		System.out.println(s.get());
	}

}


class A{
	
	public void print() {
		System.out.println("Printing inside lambda");
	}
}