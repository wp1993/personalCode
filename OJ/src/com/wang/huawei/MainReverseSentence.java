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
 * ��һ��Ӣ������Ե���Ϊ��λ�����ŷš����硰I am a boy���������ŷź�Ϊ��boy a am I��
���е���֮����һ���ո����������г���Ӣ����ĸ�⣬���ٰ��������ַ�


�ӿ�˵��

/**
 * ��ת����
 * 
 * @param sentence ԭ����
 * @return ��ת��ľ���
 *
public String reverse(String sentence);
 * 
 * 
 * 
 */