package com.wang.huawei;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class stringMerge {

 public static void main(String[] args) throws IOException {
  Scanner sc = new Scanner(System.in);
  while (sc.hasNext()) {
   String str1 = sc.next();
   String str2 = sc.next();
   System.out.println(str1 + ":" + str2);
   String str3 = str1 + str2;

   System.out.println(str3.length() / 2);
   char[] ch1 = new char[str3.length() / 2 + str3.length() % 2];
   char[] ch2 = new char[str3.length() / 2];
   int j = 0, k = 0;
   
   for (int i = 0; i < str3.length(); i++) {
    char ch = str3.charAt(i);
    if (i % 2 == 0) {
     ch1[j++] = ch;
    } else {
     ch2[k++] = ch;
    }
   }
   
   Arrays.sort(ch1);
   Arrays.sort(ch2);
   
   int m = 0, n = 0;
   StringBuffer sb = new StringBuffer("");
   for (int i = 0; i < str3.length(); i++) {
    if (i % 2 == 0) {
     sb.append(ch1[m++]);
    } else {
     sb.append(ch2[n++]);
    }
   }
   
   System.out.println(sb.toString());
   
   int len = sb.toString().length();
   String[] hexStr = new String[len];
   int[] intStr = new int[len];
   String[] newStr = new String[len];
   int[] newInt = new int[len];
   String strOutput = "";
   for (int i = 0; i < len; i++) {
    intStr[i] = Integer.parseInt(String.valueOf(sb.charAt(i)), 16);
    hexStr[i] = Integer.toBinaryString(intStr[i]);
    newStr[i] = new StringBuffer(hexStr[i]).reverse().toString();
    newInt[i] = Integer.parseInt(newStr[i], 2);
    strOutput += Integer.toHexString(newInt[i]).toUpperCase();
   }
   System.out.println(strOutput);
  }
  sc.close();
 }
}