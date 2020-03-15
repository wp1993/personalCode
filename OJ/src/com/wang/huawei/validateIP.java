package com.wang.huawei;

import java.util.Scanner;

public class validateIP {

	/**
	 * @param args
	 * ˼·
	 * 1.�ж��Ƿ�Ϸ�
	 * 		����0.*.*.*
	 * 		���ҵ����ͣ���IP�Ϸ�
	 * 		����Ϸ�
	 * 
	 * 3.�ж��Ƿ�˽��
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
		//�Ƚ��кϷ����ж�
		if(validateIP(ipArry) && validateSubnetMask(subnetMaskArry)){
			//�Ϸ������ж�����
			//A B C D E ֻ�͵�һ����ַ�й�
			//ͬʱ����˽��ip�ж�
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
		//��ѡ���ȱ���Ϊ4
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
		//�����������ʽ��0������1֮ǰ����
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
�����IP��ַ�Ͷ�Ӧ�����룬���з���ʶ��Ҫ����A/B/C/D/E���ַ���࣬���Ϸ��ĵ�ַ�����뵥�����ࡣ

���е�IP��ַ����Ϊ A,B,C,D,E����

A���ַ1.0.0.0~126.255.255.255;

B���ַ128.0.0.0~191.255.255.255;

C���ַ192.0.0.0~223.255.255.255;

D���ַ224.0.0.0~239.255.255.255��

E���ַ240.0.0.0~255.255.255.255

˽��IP��Χ�ǣ�

10.0.0.0��10.255.255.255

172.16.0.0��172.31.255.255

192.168.0.0��192.168.255.255


��������Ϊ��������ǰ����������1��Ȼ��ȫ��0�������磺255.255.255.32����һ���Ƿ������룩
ע���������ȫ��1����ȫ��0��Ϊ�Ƿ�

ע�⣺
1. �����ڡ�0.*.*.*����IP��ַ�������������������һ�࣬Ҳ�����ڲ��Ϸ�ip��ַ������ʱ���Ժ���
2. ˽��IP��ַ��A,B,C,D,E���ַ�ǲ���ͻ��

input�������ַ�����ÿ��һ��IP��ַ�����룬��~������
10.70.44.68~255.254.255.0
1.0.0.1~255.0.0.0
192.168.0.2~255.255.255.0
19..0.~255.255.255.0
output��ͳ��A��B��C��D��E������IP��ַ��������롢˽��IP�ĸ�����֮���Կո������
1 0 1 0 0 2 1
*/