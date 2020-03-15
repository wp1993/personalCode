package com.wang.datastructure;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/*
 * 1.变换为稀疏数组
 * 稀疏数组是
 * 假定二维数组是int[n][m] count为有效的数值数
 * 稀疏数组：
 * [n,m,count]
 * [i,j,v]  i，j标识二维数组中的位置，v表示该值
 */
public class SparseArry {
	public static void main(String[] args) throws IOException {
		//toSparseArray();
		showArray(spaerseToOrigin());
	}
	
	//原始二维数组的输出
	private static void showArray(int[][] spaerseToOrigin) {
		for (int[] is : spaerseToOrigin) {
			for (int i : is) {
				if(i>0){
					System.out.print("o"+" ");
				}else {
					System.out.print("+"+" ");
				}
			}
			System.out.println();
		}
	}
	/*
	 * 稀疏数组转换为原始的二维数组
	 */
	private static int[][] spaerseToOrigin() throws IOException {
		File file = new File("./files/20200312124803.txt");
		Reader in = new FileReader(file);
		BufferedReader bReader = new BufferedReader(in);
		
		String line;
		String[] str0 = bReader.readLine().split(" ");
		Integer m = new Integer(str0[0]);
		Integer n = new Integer(str0[1]);
		int[][] oringinalArray = new int[m][n];
		while((line=bReader.readLine())!=null){
			String[] string = line.split(" ");
			int i = Integer.valueOf(string[0]);
			int j = Integer.valueOf(string[1]);
			int v = Integer.valueOf(string[2]);
			oringinalArray[i][j] = v;
		}
		return oringinalArray;
		
	}
	/*
	 * 变换为稀疏数组之后，并保存到文件中
	 */
	private static void toSparseArray() throws IOException {
				Scanner scanner  = new Scanner(System.in);
				int[][] initialArray = new int[11][11];
				while (scanner.hasNextInt()) {
					int i = scanner.nextInt();
					int j = scanner.nextInt();
					int v = scanner.nextInt();
					if (v==0) {
						break;
					}
					initialArray[i][j] = v ;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				String fileName ="./files/" +sdf.format(new Date())+".txt";
				File file = new File(fileName);
//				saveToFile(initialArray, file);
				saveToFile(initToSparse(initialArray), file);
	}
	/*
	 * 1.保存稀疏数组到文件中
	 */
	private static void saveToFile(int[][] initToSparse,File file) throws IOException {
		//新建实例时，第二个参数控制是否新增
		FileWriter fw = new FileWriter(file,true);
		
		for (int[] is : initToSparse) {
			for (int i : is) {
				fw.write(i+" ");
			}
			fw.write("\n");
		}
		fw.close();
	}
/*
 * 将原始的二维数组变换为稀疏数组
 */
	private static int[][] initToSparse(int[][] initialArray) {
		//遍历数组，求有效的数个总个数
		int count = 0;
		for(int[] row : initialArray){
			for(int data :row){
				if (data>0) {
					count++;
				}
			}
		}
		//第一行：行数，列数，有效值个数
		int[][] sparseArray = new int[count+1][3];
		sparseArray[0][0]=initialArray.length;
		sparseArray[0][1]= initialArray[0].length;
		sparseArray[0][2]=count;
		//有效值的行值，列值，值
		int index=1;
		for (int i = 0; i < initialArray.length; i++) {
			for (int j = 0; j < initialArray[i].length; j++) {
				if (initialArray[i][j]>0) {
					sparseArray[index][0]=i;
					sparseArray[index][1]=j;
					sparseArray[index++][2]=initialArray[i][j];
				}
			}
		}
		return sparseArray;
	}
	
	
	
	
}
