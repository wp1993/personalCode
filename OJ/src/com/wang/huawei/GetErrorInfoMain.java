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
开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
处理：
1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），
对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
3、 输入的文件可能带路径，记录文件名称不能带路径。

input:
一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开
E:\V1R2\product\fpgadrive.c   1325

output:
将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
fpgadrive.c 1325 1


*/
