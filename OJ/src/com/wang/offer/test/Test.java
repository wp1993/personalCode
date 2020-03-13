package com.wang.offer.test;

import java.lang.annotation.Target;

import com.wang.offer.Solution;

public class Test {

	
	@org.junit.Test
	public void test1(){
		int i =4 ;
		int[][] array={{1,2,3,4},{1,2,3,4}};
		Solution solution=new Solution();
		boolean b=solution.Find(i, array);
		System.out.println(b);
	}
}
