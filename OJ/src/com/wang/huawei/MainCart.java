package com.wang.huawei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainCart {
	/*
	 * 思路：
	 * 1.1<=i<=n
	 * 2.f(i/n)= q[1]**f(i-1/n-1)+...q[j]**f(i-1/n-j)+...
	 * 3.1<=j<=n-i+1  && j<=n-1/2 
	 * 4.f(n/n)={q[1]+++q[n]}
	 * 5.i-1=1:   f(i-1/n-j)={q[n-j],q[n-j+1]....q[n]}
	 * 
	 * 
	 */
	public static void main(String[] args) {
		Scanner  scanner=new java.util.Scanner(System.in);
		int m =0,n=0;
		int[] v = new int[61];
		int[] p = new int[61];
		int[] q = new int[61];
		int j=1;
		m=scanner.nextInt();
		n=scanner.nextInt();
		while(scanner.hasNextInt()){
			v[j]=scanner.nextInt();
			p[j]=scanner.nextInt();
			q[j]=scanner.nextInt();
			if(v[j]==0){
				break;
			}
			j++;
		}
		System.out.println(j);
		getResult(m, n, v, p, q);
		
		
		scanner.close();
		 
	}
	
	
	
	public static void getResult(int m,int n,int[] v,int[] p,int[] q){
		int sum=0;
		for(int i=1;i<=n;i++){
			sum+=getFactorial(n)/(getFactorial(i)*getFactorial(n-i));
		}
		int[] result= new int[sum];
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=i+1;
		}
			getCombination(arr,result,3,3,n,1);
		
		
	}
	
		//arr为原始数组
		//start为遍历起始位置
		//result保存结果，为一维数组
		//count为result数组的索引值，起辅助作用
		//NUM为要选取的元素个数
		//arr_len为原始数组的长度，为定值
		public  static  void getCombination(int[] arr, int[] result, int count,  int NUM,int n ,int start)
		{
		  for (int i = start; i < n + 1 - count; i++)
		  {
		    result[count - 1] = arr[i];
		    if (count - 1 == 0)
		    {
		      int j;
		      for (j = NUM - 1; j >= 0; j--)
		        System.out.print(result[j]);
		      System.out.println();
		    }
		    else
		    	getCombination(arr, result, count - 1, NUM, n,start+1);
		  }
		}




	public static int getFactorial(int n){
		if(n>1){
			return n*getFactorial(n-1);
		}else{
			return 1;
		}
	}
	
	public static void showResult(){
		
		
	}
}


/*
王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，
他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
主件   	   附件
电脑	          打印机，扫描仪
书柜   	   图书
书桌	          台灯，文具
工作椅	    无
如果要买归类为附件的物品，必须先买该附件所属的主件。
每个主件可以有 0 个、 1 个或 2 个附件。
附件不再有从属于自己的附件。
王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。
他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。
他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
    设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
    请你帮助王强设计一个满足要求的购物单。
 


输入的第 1 行，为两个正整数，用一个空格隔开：N m

（其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）


从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q


（其中 v 表示该物品的价格（ v<10000 ），
 p 表示该物品的重要度（ 1 ~ 5 ）， 
 q 表示该物品是主件还是附件。如果 q=0 ，
 表示该物品为主件，如果 q>0 ，
 表示该物品为附件， 
 q 是所属主件的编号）
 
 
  输出文件只有一个正整数，
   为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 
 1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0

*/