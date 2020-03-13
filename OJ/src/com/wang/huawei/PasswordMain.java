package com.wang.huawei;

import java.util.Scanner;

public class PasswordMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			showResult(getResult(scanner.next()));
		}
		
	}

	private static void showResult(String result) {
		System.out.println(result);
	}

	private static String  getResult(String next) {
		String string ="";
		for (int i = 0; i < next.length(); i++) {
			string+=getSingleChar(next.charAt(i));
		}
		return string;
	}

	private static char getSingleChar(char charAt) {
		// abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9
		if (charAt>='a'&&charAt<='z') {
			char c='0';
			switch (charAt) {
				case 'a': ;
				case 'b': ;
				case 'c': c='2';break;
				
				case 'd': ;
				case 'e': ;
				case 'f': c='3';break;
				
				case 'g': ;
				case 'h': ;
				case 'i': c='4';break;
				
				case 'j': ;
				case 'k': ;
				case 'l': c='5';break;
				
				case 'm': ;
				case 'n': ;
				case 'o': c='6';break;
				
				case 'q': ;
				case 'p': ;
				case 'r':;
				case 's':;c='7';break;
				
				case 't': ;
				case 'u': ;
				case 'v': c='8';break;
				
				case 'w': ;
				case 'x': ;
				case 'y': ;
				case 'z': c='9';break;
				default:
					break;
			}
			return c;
		}else if(charAt>='A'&&charAt<='Z'){
			if (charAt=='Z') {
				return 'a';
			}else {
				return (char) ((int)charAt+1+32);
			}
		}else {
			return charAt;
		}
	}

}

/**
*
���������������зǳ���Ҫ�Ķ��������ǵ���ôһ�㲻��˵�����ܾ�ȫ�����ˡ��۹���. ������Ԩ��Ҫ������֮���ټ�һ�����룬��Ȼ�򵥵�Ҳ��ȫ��

 

����Ԩ��ԭ��һ��BBS�ϵ�����Ϊzvbo9441987,Ϊ�˷�����䣬
��ͨ��һ���㷨���������任��YUANzhi1987��
����������������ֺͳ�����ݣ���ô���������ˣ�
���ҿ�����Ŀ�ŵ��ط������۵ĵط�����������֪�����������롣

 

������ô�任�ģ���Ҷ�֪���ֻ��ϵ���ĸ�� 1--1�� abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
����ô�򵥣�Ԩ�Ӱ������г��ֵ�Сд��ĸ����ɶ�Ӧ�����֣����ֺ������ķ��Ŷ������任��
������������û�пո񣬶������г��ֵĴ�д��ĸ����Сд֮��������һλ���磺X���ȱ��Сд����������һλ��������y����򵥰ɡ���ס��z��������aŶ��

YUANzhi1987
zvbo9441987

*/