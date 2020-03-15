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
			}//已经判断过的字符，不再判断
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
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 * 用例:

uqic^g`(s&jnl(m#vt!onwdj(ru+os&wx
对应输出应该为:

24

 * 
 */