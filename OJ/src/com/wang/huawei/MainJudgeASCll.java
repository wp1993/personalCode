package com.wang.huawei;

import java.util.Scanner;

public class MainJudgeASCll {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new java.util.Scanner(System.in);
		if(scanner.hasNextLine()){
			System.out.println(checkASCll(scanner.nextLine()));
		}
	}

	
	
	public static int checkASCll(String str){
		int num=0;
		String tempString="";
		for (int i = 0; i < str.length(); i++) {
			
			if(tempString.indexOf(str.charAt(i))>-1){
				continue;
			}//�Ѿ��жϹ����ַ��������ж�
			tempString+=str.charAt(i);
			if(0<str.charAt(i)&&str.charAt(i)<127){
				num++;
			}
		}
		return  num;
	}
}
/**
 * 
 * ��дһ�������������ַ����к��еĲ�ͬ�ַ��ĸ������ַ���ACSII�뷶Χ��(0~127)�����б�ʾ���������������ַ�����ڷ�Χ�ڵĲ���ͳ�ơ�
 * ����:

uqic^g`(s&jnl(m#vt!onwdj(ru+os&wx
��Ӧ���Ӧ��Ϊ:

24

 * 
 */