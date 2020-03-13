package com.wang.huawei;

import java.util.Arrays;
import java.util.Scanner;


public class MergeStringMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str0 = scanner.next();
			String  str1 = scanner.next();
			String string=str0+str1;
			getResult(string);
		}
	}
	
	public  static void getResult(String string){
		String str1="";
		String str2="";
		for(int i=0;i<string.length();i++){
			if(i%2==0){
				str1+=string.substring(i, i+1);
			}else {
				str2+=string.substring(i, i+1);
			}
		}
		char[] ch1= str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		StringBuffer str=new StringBuffer();
		int m=0,n=0;
		for(int i=0;i<string.length();i++){
			if(i%2==0){
				str.append(getSingleHex(ch1[m++]));
			}else {
				str.append(getSingleHex(ch2[n++]));
			}
		}
		showResult(str);
	}
	
	public  static String getSingleHex(char c){
		String temp = String.valueOf(c);
		if((c>='a'&&c<='f')||(c>='A'&&c<='F')||(c>='0'&&c<='9')){
			String i= Integer.toBinaryString(Integer.parseInt(temp, 16));
			while(i.length()<4){
        		i="0"+i;
        	}
			 String iVerse =new StringBuffer(i).reverse().toString();
			 return Integer.toHexString(Integer.parseInt(iVerse, 2)).toUpperCase() ;
        }else {
        	return temp;
		}
	}
	
	public static void showResult(StringBuffer str){
		System.out.println(str);
	}

}


/*
题目描述
按照指定规则对输入的字符串进行处理。

详细描述：

将输入的两个字符串合并。

对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。

对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，
则对他们所代表的16进制的数进行BIT倒序的操作，
并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’；
 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。


举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”

接口设计及说明：

/*

功能:字符串处理

输入:两个字符串,需要异常处理

输出:合并处理后的字符串，具体要求参考文档

返回:无
dec fab
5D37BF

input :DKSq8qykpgKIZxiRKmQ9QkZt909PffE6Gyfc57dBx7p20D42bWJRzKqGGCzzQ4p7Z32Dsx2Cf8G2841lPuAZNb K0fHodOVFlbl220ov260TPOrmZ328d1E89OatcL88EXr622RdklXtXazO7wMoc6DEKU45eQ5VBUy2YFjgJX
output:000080844444444444C42CA2A2626A661E1E1E1E11919959BD7D73F3FBGBGBG7J7KGKHKILJNKOKOKOMOPPPQRQRQRQVSWTXUXUYVZXZX5ZDZ3Z353DBDBB7BFFgFjFkFkgkilllmlomoopqpqprqrsttutxvxwyxyyzzzz


*/