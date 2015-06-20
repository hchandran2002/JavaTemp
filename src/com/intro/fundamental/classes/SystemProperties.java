package com.intro.fundamental.classes;

import java.util.Properties;
import java.util.Set;

public class SystemProperties {

	public static void main(String[] args) {
		
		Properties systemProps = System.getProperties();
		Set<Object> keySet = systemProps.keySet();
		for(Object obj : keySet){
		    String key = (String) obj;
		    System.out.println("{"+obj+"="+systemProps.getProperty(key)+"}");
		}
		 
		//Get Specific Property
		System.out.println(System.getProperty("user.country"));
		 
		//Clear property example
		System.clearProperty("user.country");
		System.out.println(System.getProperty("user.country")); //print null
		 
		//Set System property
		System.setProperty("user.country", "IN");
		System.out.println(System.getProperty("user.country"));

	}

}
