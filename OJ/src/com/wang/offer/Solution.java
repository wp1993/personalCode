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

在一个二维数组中（每个一维数组的长度相同），
每一行都按照从左到右递增的顺序排序，
每一列都按照从上到下递增的顺序排序。
请完成一个函数，
输入这样的一个二维数组和一个整数，
判断数组中是否含有该整数。
*/