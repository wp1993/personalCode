package com.wang.huawei;

import java.util.Scanner;

public class MainReverseSentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new java.util.Scanner(System.in);
		if(scanner.hasNextLine()){
			System.out.println(reverseSentense(scanner.nextLine()));
		}
		}
	
	
	public static String reverseSentense(String oldString){
		String[] oldStrings=oldString.split(" ");
		String tempString="";
		for (int i = 0; i < oldStrings.length; i++) {
			tempString=oldStrings[i]+" "+tempString;
		}
		return tempString;
	}

}

/*
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符


接口说明

/**
 * 反转句子
 * 
 * @param sentence 原句子
 * @return 反转后的句子
 *
public String reverse(String sentence);
 * 
 * 
 * 
 */