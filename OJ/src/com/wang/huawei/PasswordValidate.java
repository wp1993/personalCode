package com.wang.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PasswordValidate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()) {
			String string = scanner.next();
			String resultString =validatePassW(string);
			showResult(resultString);
		}
	}

	private static String validatePassW(String string) {
		if(string.length()<=8){
			return "NG";
		}
		int[] k= new int[4];
		for (int i = 0; i < string.length(); i++) {
			if((string.charAt(i)<='9'&&string.charAt(i)>='0')){
				k[0]=1;
			}
			else if((string.charAt(i)<='Z'&&string.charAt(i)>='A')){
				k[1]=1;
			}
			else if((string.charAt(i)<='z'&&string.charAt(i)>='a')){
				k[2]=1;
			}else {
				k[3]=1;
			}
			
		}
		int sum=0;
		for (int i = 0; i < k.length; i++) {
			sum+=k[i];
		}
		if(sum<3){
			return "NG";
		}
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < string.length(); i++) {
			for (int j = i+3; j<= string.length(); j++) {
				if(!set.add(string.substring(i, j))){
					return "NG";
				}
			}
			
		}
		return "OK";
	}

	private static void showResult(String resultString) {
		System.out.println(resultString);
	}

}
/***


密码要求:
 

1.长度超过8位

2.包括大小写字母.数字.其它符号,以上四种至少三种

3.不能有相同长度超2的子串重复

说明:长度超过2的子串

输入描述:
一组或多组长度超过2的子符串。每组占一行
021Abc9000
021Abc9Abc1
021ABC9000
021$bc9000
输出描述:
如果符合要求输出：OK，否则输出NG
OK
NG
NG
OK

*/
