package com.intro.fundamental.classes;

import java.util.Arrays;

public class SystemArrayCopy {

	public static void main(String[] args) {
		
		int [] array1 = {1,2,3,4,5};
		int[] array2 = {10,20,30,40,50};
		 
		//copying first two elements from array1 to array2 starting from index 2 of array2
		System.arraycopy(array1, 0, array2, 2, 2);
		 
		System.out.println(Arrays.toString(array2)); 

	}

}
