package com.intro.fundamental.classes;

import java.util.Map;
import java.util.Set;

public class SystemEnvironmentalVariables {

	public static void main(String[] args) {
		
		//get unmodifiable environment variables map
		Map<String, String> envMap = System.getenv();
		Set<String> keySet = envMap.keySet();
		for(String key : keySet){
		    System.out.println("Key="+key+",value="+envMap.get(key));
		}
		 
		//Get Specific environment variable
		String pathValue = System.getenv("PATH");
		System.out.println("$PATH="+pathValue);

	}

}
