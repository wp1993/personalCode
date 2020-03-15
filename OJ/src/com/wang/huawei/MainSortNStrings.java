package com.wang.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class MainSortNStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner=new java.util.Scanner(System.in);
		while(scanner.hasNext()){
			int n=scanner.nextInt();
			String[] strs=new String[n];
			scanner.nextLine();
			for (int i = 0; i < n; i++) {
				String tempString=scanner.nextLine();
				if(!"".equals(tempString)&&tempString!=null){
					strs[i]=tempString;
				}
			}
			
			sortNStrings(n,strs);
			showStrings(strs);
		}
	}
	
    public static void sortNStrings(int n,String[] strs){
    	Arrays.sort(strs, 0, n, new MyComparator());
    }
    

    
    
    
    public static void showStrings(String[] strs){
    	for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
    }
}

class MyComparator implements java.util.Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		int i=0;
		for (int j = 0; j < o1.length() &&j<o2.length() ; j++) {
			i=o1.charAt(j)-o2.charAt(j);
			if(i!=0){
				return i;
			}
		}
		if(i==0){
			return o1.length()-o2.length();
		}
		return i;
		
	}
	  
	  
}
/*
 * 
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 
 * 
 * 9
cap
to
cat
card
two
too
up
boat
boot

输出：
boat
boot
cap
card
cat
to
too
two
up
 */