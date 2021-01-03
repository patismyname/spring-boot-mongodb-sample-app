/**
 * 
 */
package com.pattana.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Pattana.Kaewsai
 *
 */
public class LogicalTest {

	/**
	 * 
	 */
	public LogicalTest() {
		// TODO Auto-generated constructor stub
	}

	//Q #1) Write a Java Program to reverse a string without using String inbuilt function.
	
	public static void Q1(String str) {		
	
        StringBuilder str2 = new StringBuilder();
        str2.append(str);
        System.out.println("str2=>"+str2);
        str2 = str2.reverse();     // used string builder to reverse
        System.out.println("str2=>>"+str2);
	}
	
	//Q #2) Write a Java Program to reverse a string without using String inbuilt function reverse().
	
	public static void Q2(String str) {
		
        char chars[] = str.toCharArray();  // converted to character array and printed in reverse order
        for(int i= chars.length-1; i>=0; i--) {
            System.out.print(chars[i]);
        }
	}
	//Q #3) Write a Java Program to swap two numbers using the third variable.
	public static void Q3() {
        int x, y, temp;
        System.out.println("Enter x and y");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        System.out.println("Before Swapping" + x + y);
        temp = x;
        x = y;
        y = temp;
        System.out.println("After Swapping" + x + y);
	}


	public static boolean solution(int... A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
				if (isSort(A)) {
					return true;
				} else {
					tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
				}//if
			}//for
		}//for
		return false;
	}

	public static boolean isSort(int... A) {
		int old = A[0];
		for (int i : A) {
			if (old > i)
				return false;
			old = i;
		}
		return true;
	}

	public static boolean solution2(int... A) {
		int[] B = Arrays.copyOf(A, A.length);

		Arrays.sort(B);

		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != B[i]) {
				count++;
				if (count > 2) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	     // String str = "Automation";
	     // LogicalTest.Q1(str);
	      
		 // String str = "Saket Saurav";
	    //  LogicalTest.Q1(str);		
	
		boolean bool=LogicalTest.solution(1,5,3,3,7);
		System.out.println(""+bool);
		
		
		
		int count = 0 ;
		int [] A = new int[] {1,2,3,4,4,4,4,4,5,5,5,6,5,5,5,5,5,8};
		int c = A.length;
		System.out.println(c);
		System.out.println("Array starts");
		for (int i = 0 ; i< c ; i++){
		for (int j = i+1 ; j < c ; j++) {
		if (A[i] == A[j]) {
		for (int p = j; p < c - 1; p++) {
		A[p] = A[p + 1];
		}
		j= j -1;
		c = c - 1;
		}
		}
		}


		for (int i = 0 ; i < c; i++){
		System.out.println(A[i]);
		
	  }
	}

}
