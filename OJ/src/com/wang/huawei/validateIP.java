package com.wang.huawei;

import java.util.Scanner;

public class validateIP {

	/**
	 * @param args
	 * 思路
	 * 1.判断是否合法
	 * 		忽略0.*.*.*
	 * 		能找到类型，则IP合法
	 * 		掩码合法
	 * 
	 * 3.判断是否私有
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] result = new int[7];
		if (scanner.hasNext()) {
			getResult(scanner.next(),result);
		}
		showResult(result);
	}

	private static void showResult(int[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (i<result.length-1) {
				System.out.print(" ");
			}
			
		}
	}

	private static void getResult(String next, int[] result) {
		String[] strings = next.split("~");
		String[] ipArry=strings[0].split("\\.");
		String[] subnetMaskArry=strings[1].split("\\.");
		judgeType(ipArry,subnetMaskArry,result);
	}

	private static void judgeType(String[] ipArry, String[] subnetMaskArry, int[] result) {
		//先进行合法性判断
		if(validateIP(ipArry) && validateSubnetMask(subnetMaskArry)){
			//合法，在判断类型
			//A B C D E 只和第一个地址有关
			//同时进行私有ip判断
			int ip0 =Integer.parseInt(ipArry[0]);
			int ip1 = Integer.parseInt(ipArry[1]);
			if(ip0>=1 && ip0<=126){
				result[0]++;
				if(ip0==10){
					result[6]++;
				}
			}else if (ip0>=128&&ip0<=191) {
				result[1]++;
				if (ip0==172&&ip1>=16&&ip1<=31) {
					result[6]++;
				}
			}
			else if (ip0>=192&&ip0<=223) {
				result[2]++;
				if (ip0==192&&ip1==168) {
					result[6]++;
				}
			}
			else if (ip0>=224&&ip0<=239) {
				result[3]++;
			}
			else if (ip0>=240&&ip0<=255) {
				result[4]++;
			}
		}else {
			result[5]++;
		}
	}

	private static boolean validateSubnetMask(String[] subnetMaskArry) {
		String string="";
		//首选长度必须为4
		if(subnetMaskArry.length<4){
			return false;
		}
		for (int i = 0; i < subnetMaskArry.length; i++) {
			if(subnetMaskArry[i]==null){
				return false;
			}
			String bString= Integer.toBinaryString(Integer.parseInt(subnetMaskArry[i]));
			while(bString.length()<8 ){
				bString="0"+bString;
			}
			string+=bString;
		}
		//掩码二进制形式，0不能在1之前出现
		if(string.indexOf('1', string.indexOf('0'))>-1){
			return false;
		}
		return true;
	}

	private static boolean validateIP(String[] ipArry) {
		if(ipArry.length<4){
			return false;
		}
		for (int i = 0; i < ipArry.length; i++) {
			if(ipArry[i]==null){
				return false;
			}
		}
		return true;
	}

}


/*
请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。

所有的IP地址划分为 A,B,C,D,E五类

A类地址1.0.0.0~126.255.255.255;

B类地址128.0.0.0~191.255.255.255;

C类地址192.0.0.0~223.255.255.255;

D类地址224.0.0.0~239.255.255.255；

E类地址240.0.0.0~255.255.255.255

私网IP范围是：

10.0.0.0～10.255.255.255

172.16.0.0～172.31.255.255

192.168.0.0～192.168.255.255


子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
注意二进制下全是1或者全是0均为非法

注意：
1. 类似于【0.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时可以忽略
2. 私有IP地址和A,B,C,D,E类地址是不冲突的

input：多行字符串。每行一个IP地址和掩码，用~隔开。
10.70.44.68~255.254.255.0
1.0.0.1~255.0.0.0
192.168.0.2~255.255.255.0
19..0.~255.255.255.0
output：统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
1 0 1 0 0 2 1
*/