package com.wang.huawei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainCart {
	/*
	 * ˼·��
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
	
		//arrΪԭʼ����
		//startΪ������ʼλ��
		//result��������Ϊһά����
		//countΪresult���������ֵ����������
		//NUMΪҪѡȡ��Ԫ�ظ���
		//arr_lenΪԭʼ����ĳ��ȣ�Ϊ��ֵ
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
��ǿ����ܿ��ģ���˾����NԪ�����ս�����ǿ���������ս����ڹ��
�����������Ʒ��Ϊ���ࣺ�����븽���������Ǵ�����ĳ�������ģ��±����һЩ�����븽�������ӣ�
����   	   ����
����	          ��ӡ����ɨ����
���   	   ͼ��
����	          ̨�ƣ��ľ�
������	    ��
���Ҫ�����Ϊ��������Ʒ����������ø���������������
ÿ������������ 0 ���� 1 ���� 2 ��������
���������д������Լ��ĸ�����
��ǿ����Ķ����ܶ࣬Ϊ�˲�����Ԥ�㣬����ÿ����Ʒ�涨��һ����Ҫ�ȣ���Ϊ 5 �ȣ������� 1 ~ 5 ��ʾ���� 5 ������Ҫ��
�������������ϲ鵽��ÿ����Ʒ�ļ۸񣨶��� 10 Ԫ������������
��ϣ���ڲ����� N Ԫ�����Ե��� N Ԫ����ǰ���£�ʹÿ����Ʒ�ļ۸�����Ҫ�ȵĳ˻����ܺ����
    ��� j ����Ʒ�ļ۸�Ϊ v[j] ����Ҫ��Ϊ w[j] ����ѡ���� k ����Ʒ���������Ϊ j 1 �� j 2 �������� j k ����������ܺ�Ϊ��
v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ �� +v[j k ]*w[j k ] �������� * Ϊ�˺ţ�
    ���������ǿ���һ������Ҫ��Ĺ��ﵥ��
 


����ĵ� 1 �У�Ϊ��������������һ���ո������N m

������ N �� <32000 ����ʾ��Ǯ���� m �� <60 ��Ϊϣ��������Ʒ�ĸ�������


�ӵ� 2 �е��� m+1 �У��� j �и����˱��Ϊ j-1 ����Ʒ�Ļ������ݣ�ÿ���� 3 ���Ǹ����� v p q


������ v ��ʾ����Ʒ�ļ۸� v<10000 ����
 p ��ʾ����Ʒ����Ҫ�ȣ� 1 ~ 5 ���� 
 q ��ʾ����Ʒ���������Ǹ�������� q=0 ��
 ��ʾ����ƷΪ��������� q>0 ��
 ��ʾ����ƷΪ������ 
 q �����������ı�ţ�
 
 
  ����ļ�ֻ��һ����������
   Ϊ��������Ǯ������Ʒ�ļ۸�����Ҫ�ȳ˻����ܺ͵����ֵ�� <200000 ����
 
 1000 5
800 2 0
400 5 1
300 5 1
400 3 0
500 2 0

*/