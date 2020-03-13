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
密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。

 

假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，
他通过一种算法把这个密码变换成YUANzhi1987，
这个密码是他的名字和出生年份，怎么忘都忘不了，
而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。

 

他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。

YUANzhi1987
zvbo9441987

*/