package com.wang.huawei.test;

import com.wang.huawei.MainNotRepeat;

public class Test {
	@org.junit.Test
	public void test1(){
		MainNotRepeat mnr=new MainNotRepeat();
		System.out.println(mnr.getNoRepeatNum());
	}
}
