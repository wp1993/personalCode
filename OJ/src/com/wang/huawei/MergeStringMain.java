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
��Ŀ����
����ָ�������������ַ������д���

��ϸ������

������������ַ����ϲ���

�Ժϲ�����ַ�����������Ҫ��Ϊ���±�Ϊ�������ַ����±�Ϊż�����ַ��ֱ��С��������������±���˼���ַ����ַ����е�λ�á�

���������ַ������в���������ַ�Ϊ��0��������9�����ߡ�A��������F�����ߡ�a��������f����
��������������16���Ƶ�������BIT����Ĳ�����
��ת��Ϊ��Ӧ�Ĵ�д�ַ������ַ�Ϊ��4����Ϊ0100b����ת��Ϊ0010b��Ҳ����2��ת������ַ�Ϊ��2����
 ���ַ�Ϊ��7����Ϊ0111b����ת��Ϊ1110b��Ҳ����e��ת������ַ�Ϊ��д��E����


����������str1Ϊ"dec"��str2Ϊ"fab"���ϲ�Ϊ��decfab�����ֱ�ԡ�dca���͡�efb���������������Ϊ��abcedf����ת����Ϊ��5D37BF��

�ӿ���Ƽ�˵����

/*

����:�ַ�������

����:�����ַ���,��Ҫ�쳣����

���:�ϲ��������ַ���������Ҫ��ο��ĵ�

����:��
dec fab
5D37BF

input :DKSq8qykpgKIZxiRKmQ9QkZt909PffE6Gyfc57dBx7p20D42bWJRzKqGGCzzQ4p7Z32Dsx2Cf8G2841lPuAZNb K0fHodOVFlbl220ov260TPOrmZ328d1E89OatcL88EXr622RdklXtXazO7wMoc6DEKU45eQ5VBUy2YFjgJX
output:000080844444444444C42CA2A2626A661E1E1E1E11919959BD7D73F3FBGBGBG7J7KGKHKILJNKOKOKOMOPPPQRQRQRQVSWTXUXUYVZXZX5ZDZ3Z353DBDBB7BFFgFjFkFkgkilllmlomoopqpqprqrsttutxvxwyxyyzzzz


*/