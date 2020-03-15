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
开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。

输入：

合法坐标为A(或者D或者W或者S) + 数字（两位以内）

坐标之间以;分隔。

非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。

下面是一个简单的例子 如：

A10;S20;W10;D30;X;A1A;B10A11;;A10;

处理过程：

起点（0,0）

+   A10   =  （-10,0）

+   S20   =  (-10,-20)

+   W10  =  (-10,-10)

+   D30  =  (20,-10)

+   x    =  无效

+   A1A   =  无效

+   B10A11   =  无效

+  一个空 不影响

+   A10  =  (10,-10)

结果 （10， -10）


input:A10;S20;W10;D30;X;A1A;B10A11;;A10;
output:10,-10

//思路：
 * 1.单个字符无效判断
 *   第一个字符必须为A S D W中的一个
 *   并且余下的必须为0-99
 * 2.有效字符计算坐标
 */

