package com.wang.huawei;

import java.util.Scanner;

public class SodaMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			System.out.println(getResult(scanner.nextInt()));
		}
	}
	/*
	 * ˼·���ݹ����
	 * n>=3ʱ��
	 * f(n)=n/3 + f(n/3+n%3)
	 * n=2
	 * f(2)=1
	 * f(1),f(0)=0
	 */
	
	public static int getResult(int n){
		int sum = 0;
		if(n>=3){
			sum += n/3 +getResult(n/3+n%3);
		}else if(n==2){
			sum = 1;
		}else {
			sum=0;
		}
		return sum;
	}
	
}
/*
������һ�������⣺��ĳ�̵�涨����������ˮƿ���Ի�һƿ��ˮ��
С��������ʮ������ˮƿ���������Ի�����ƿ��ˮ�ȣ�
������5ƿ���������£�����9����ƿ�ӻ�3ƿ��ˮ���ȵ�3ƿ���ģ������Ժ�4����ƿ�ӣ�
��3���ٻ�һƿ���ȵ���ƿ���ģ���ʱ��ʣ2����ƿ�ӡ�
Ȼ�������ϰ��Ƚ����һƿ��ˮ���ȵ���ƿ���ģ������Ժ���3����ƿ�ӻ�һƿ���Ļ����ϰ塣
���С��������n������ˮƿ�������Ի�����ƿ��ˮ�ȣ�

input��
�����ļ�������10��������ݣ�ÿ������ռһ�У�������һ��������n��1<=n<=100������ʾС�����ϵĿ���ˮƿ����n=0��ʾ�����������ĳ���Ӧ��������һ�С�
3
10
81
0
output:
����ÿ��������ݣ����һ�У���ʾ�����Ժȵ���ˮƿ�������һƿҲ�Ȳ��������0��
1
5
40

*/