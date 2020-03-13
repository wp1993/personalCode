package com.wang.huawei;

import java.util.Scanner;

public class MainReverseInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new java.util.Scanner(System.in);
		if(scanner.hasNextLine()){
			System.out.println(reverseInt(scanner.nextLine()));
		}
	}
	
	public static String reverseInt(String str){
		StringBuffer sBuffer= new StringBuffer(str);
		return sBuffer.reverse().toString();
	}

}
