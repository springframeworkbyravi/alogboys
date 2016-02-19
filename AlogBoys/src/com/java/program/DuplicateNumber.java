package com.java.program;

import java.util.Arrays;

/**
 * Find duplicate number between 1 to N.
 * 
 * You have got a range of numbers between 1 to N, where one of the number is
 * repeated. You need to write a program to find out the duplicate number
 * 
 * @author ravikson
 * 
 * @Output: 2 is duplicate 5 is duplicate
 * 
 */
public class DuplicateNumber {
	public static void main(String[] args) {

		int[] array = { 1, 2, 2, 3, 4, 5, 5, 6 };
		Arrays.sort(array);
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] == array[i + 1]) {
				System.out.println(array[i] + " is duplicate");
			}
		}
	}
}
