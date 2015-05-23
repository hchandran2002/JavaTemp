package com.intro.array;

public class CopyArraySelf {

	public static void main(String[] args) {

		char[] copyFrom = { 'd', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a',
				't', 'e', 'd' };

		char[] copyTo = new char[7];

		for (int i = 0; i < copyFrom.length; i++) {

			copyTo[i] = copyFrom[i];

			if (i == copyTo.length - 1) {
				break;
			}

		}

		for (int i = 0; i < copyTo.length; i++) {

			System.out.println("from CopyTo = " + copyTo[i]);
		}

	}
}
