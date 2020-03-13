package com.wang.huawei;

import java.util.ArrayList;
import java.util.Scanner;


public class GetErrorInfoMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> Stringlist = new ArrayList<String>();
		ArrayList<Integer> numList = new ArrayList<Integer>();
		while (scanner.hasNext()) {
			String str1 = scanner.next();
			String str2 = scanner.next();
			if (str1==""||str2=="") {
				break;
			}
			getResult(str1,str2,Stringlist,numList);
		}
		
		if (Stringlist.size()>8) {
			for (int i = Stringlist.size()-8; i <Stringlist.size(); i++) {
				String result = "";
				result = (Stringlist.get(i)+" "+numList.get(i))+" ";
				showSingle(result);
//				if (i<Stringlist.size()-1) {
//					System.out.print(" ");
//				}
			}
		}else {
			for (int i =0; i <Stringlist.size(); i++) {
				String result = "";
				result = (Stringlist.get(i)+" "+numList.get(i))+" ";
				showSingle(result);
//				if (i<Stringlist.size()-1) {
//					System.out.print(" ");
//				}
			}
		}
		
	
	}

	private static void showSingle(String string) {
		System.out.println(string);
	}

	private static void getResult(String next,String lineString, ArrayList<String> stringlist,
			ArrayList<Integer> numList) {
		String fileString =next;
		if (fileString.indexOf('\\')>-1) {
			int x = fileString.indexOf('\\', -1);
			String[] sts = fileString.split("\\\\");
			fileString = sts[sts.length-1];
		}
		if(fileString.length()>16){
			fileString=fileString.substring(fileString.length()-16, fileString.length());
		}
		String tempString = fileString+" "+lineString;
		
		if (stringlist.contains(tempString)) {
			int index = stringlist.indexOf(tempString);
			stringlist.remove(tempString);
			stringlist.add(tempString);
			numList.add(1+numList.remove(index));
		}else {
			stringlist.add(tempString);
			numList.add(1);
		}
	}

}
/*
����һ���򵥴����¼����Сģ�飬�ܹ���¼����Ĵ������ڵ��ļ����ƺ��кš�
����
1�� ��¼���8�������¼��ѭ����¼������˵���ֻ��������ֵİ��������¼����
����ͬ�Ĵ����¼�����ļ����ƺ��к���ȫƥ�䣩ֻ��¼һ��������������ӣ�
2�� ����16���ַ����ļ����ƣ�ֻ��¼�ļ��������Ч16���ַ���
3�� ������ļ����ܴ�·������¼�ļ����Ʋ��ܴ�·����

input:
һ�л�����ַ�����ÿ�а�����·���ļ����ƣ��кţ��Կո����
E:\V1R2\product\fpgadrive.c   1325

output:
�����еļ�¼ͳ�Ʋ�������������ʽ���ļ��� �������� ��Ŀ��һ���ո�������磺
fpgadrive.c 1325 1


*/
