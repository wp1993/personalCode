package com.wang.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Coordinates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		while (scanner.hasNextLine()) {
			getResult(scanner.nextLine());
		}
	}

	private static void getResult(String nextLine) {
		String[] strs = nextLine.split(";");
		Integer zeroInteger= new Integer(0);
		Map< Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(zeroInteger, zeroInteger);
		for (int i = 0; i < strs.length; i++) {
			if(strs[i].length()>=2){
				String[] handledStrings = handleString(strs[i]);
				if(judgeSingleStr(handledStrings)){
					map=calcCoordinate(handledStrings,map);
				}
			}
		}
		showResult(map);
		
	}

	private static String[] handleString(String string) {
		String[] result = {string.substring(0, 1),string.substring(1)};
		return result;
	}

	private static void showResult(Map<Integer, Integer> map) {
		Integer x = map.keySet().iterator().next();
		Integer y = map.get(x);
		System.out.println(""+x+","+y);
		
	}

	private static Map<Integer, Integer> calcCoordinate(String[] handledStrings, Map<Integer, Integer> map) {
		Integer x = map.keySet().iterator().next();
		Integer y = map.get(x);
		Integer num=new Integer(handledStrings[1]);
		switch (handledStrings[0].charAt(0)) {
		case 'A':
			x-=num;
			break;
		case 'S':
			y-=num;
			break;
		case 'D':
			x+=num;
			break;
		default:
			y+=num;
			break;
		}
		Map<Integer, Integer> newMap = new HashMap<Integer, Integer>();
		newMap.put(x, y);
		return newMap;
	}

	private static boolean judgeSingleStr(String[] handledStrings) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("S");
		list.add("D");
		list.add("W");
		if(null==handledStrings[1]||"".equals(handledStrings[1])){
			return false;
		}
		for (int i = 0; i < handledStrings[1].length(); i++) {
			if(handledStrings[1].toCharArray()[i]<'0'||handledStrings[1].toCharArray()[i]>'9'){
				return false;
			}
		}
		if(list.contains(handledStrings[0])){
			return true;
		}else {
			return false;
		}
	}
	
	

}
/*
����һ��������㹤�ߣ� A��ʾ�����ƶ���D��ʾ�����ƶ���W��ʾ�����ƶ���S��ʾ�����ƶ���
�ӣ�0,0���㿪ʼ�ƶ����������ַ��������ȡһЩ���꣬�����������������������ļ����档

���룺

�Ϸ�����ΪA(����D����W����S) + ���֣���λ���ڣ�

����֮����;�ָ���

�Ƿ��������Ҫ���ж�������AA10;  A1A;  $%$;  YAD; �ȡ�

������һ���򵥵����� �磺

A10;S20;W10;D30;X;A1A;B10A11;;A10;

������̣�

��㣨0,0��

+   A10   =  ��-10,0��

+   S20   =  (-10,-20)

+   W10  =  (-10,-10)

+   D30  =  (20,-10)

+   x    =  ��Ч

+   A1A   =  ��Ч

+   B10A11   =  ��Ч

+  һ���� ��Ӱ��

+   A10  =  (10,-10)

��� ��10�� -10��


input:A10;S20;W10;D30;X;A1A;B10A11;;A10;
output:10,-10

//˼·��
 * 1.�����ַ���Ч�ж�
 *   ��һ���ַ�����ΪA S D W�е�һ��
 *   �������µı���Ϊ0-99
 * 2.��Ч�ַ���������
 */

