package com.wang.offer;


public class Solution {
	public boolean Find(int target, int [][] array) {
			int n=array.length;
			for(int j=n-1, i=0;j>=0&&i<=array[0].length-1;){
				if(target<array[j][i]){
					j=j-1;
				}else if(target>array[j][i]){
					i=i+1;
				}else {
					return true;
				}
			}
		
		return false;
    }
}
/*
***

��һ����ά�����У�ÿ��һά����ĳ�����ͬ����
ÿһ�ж����մ����ҵ�����˳������
ÿһ�ж����մ��ϵ��µ�����˳������
�����һ��������
����������һ����ά�����һ��������
�ж��������Ƿ��и�������
*/