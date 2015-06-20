package com.intro.fundamental.classes;

import java.util.Date;

public class SystemCurrentTime {

	public static void main(String[] args) {
		
		long currentTimeMillis = System.currentTimeMillis();
		Date date = new Date(currentTimeMillis);
		System.out.println("Current time in millis="+currentTimeMillis);
		System.out.println(date); //prints 2013-08-05
		 
		long nanoTime = System.nanoTime();
		System.out.println("Current nano time="+nanoTime);

	}

}
