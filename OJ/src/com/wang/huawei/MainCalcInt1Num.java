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
����һ��int�͵����������������int���������ڴ��д洢ʱ1�ĸ�����
����һ��������int���ͣ�
 �����ת����2���ƺ����1�ĸ���

*/