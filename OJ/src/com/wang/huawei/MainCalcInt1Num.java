package com.wang.huawei;

import com.sun.java_cup.internal.runtime.Scanner;

public class MainCalcInt1Num {
	
	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		if (scanner.hasNext()) {
			int num=scanner.nextInt();
			System.out.println(calcNum(num));
		}
	}
	
	public static int calcNum(int num){
		String tempString=Integer.toBinaryString(num);
		int temp=0;
		for (int i = 0; i < tempString.length(); i++) {
			if('1'==tempString.charAt(i)){
				temp++;
			}
		}
		return temp;
	}
	
}


/*
输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
输入一个整数（int类型）
 这个数转换成2进制后，输出1的个数

*/