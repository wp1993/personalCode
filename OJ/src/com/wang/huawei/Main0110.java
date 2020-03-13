package com.wang.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main0110 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		if(scanner.hasNextLine()){
			String string= scanner.nextLine();
			showResult(getSult(string));
		}
		
	}
	
	
	public static int  getSult(String str){
		String[] strs = str.split(",");
		int[] num =new int[5];
		for (int i = 0; i < strs.length; i++) {
			
			for (int j = 0; j < 5; j++) {
				if('1'==strs[i].charAt(j)){
					num[j]++;
				}
			}
		}
		
		Arrays.sort(num);
		
		return num[0];
	}
	
	
	public static void showResult(int num){
		System.out.println(num);
	}
}
