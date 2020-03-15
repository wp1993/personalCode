package com.wang.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class MainNotRepeat {
	public static void main(String[] args) {
		System.out.println(getNoRepeatNum());
	}
	public static int getNoRepeatNum(){
		String str="";
		Scanner scanner=new java.util.Scanner(System.in);
		if(scanner.hasNextInt()){
			int i= scanner.nextInt();
			String[] strs=(""+i).split("");
			List list=new ArrayList();
			for (int j = strs.length-1; j >=0; j--) {
				if(list.contains(strs[j])|| "".equals(strs[j])){
					continue;
				}else {
					list.add(strs[j]);
				}
			}
			
			for (int j = 0; j < list.size(); j++) {
				str=list.get(j)+str;
			}
			
		}
		return (int) new Integer(str);
	}
	
	
}

/*
 * 
 * 
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * */
