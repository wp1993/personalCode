package com.wang.datastructure;

import java.util.Scanner;

/*
 * ���ζ���˼·��
 * 1.front ��ʶ��һ��ȡ���±�
 * 2.rear  ��һ�ε������±�,
 * 3.���е��ص����Ƚ��ȳ�
 * 4.�ж��Ƿ�����������count ==maxSize;
 * 5.�ж��Ƿ�գ�count==0
 */
public class CircleArrayDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CirCleQueue cirCleQueue = new CirCleQueue(3);
		while (scanner.hasNext()) {
			System.out.println("a add:");
			System.out.println("g get:");
			System.out.println("s show:");
			System.out.println("h header:");
			String string=scanner.next();
			switch (string.charAt(0)) {
			case 'a':
				try {
					cirCleQueue.add(Integer.valueOf(string.substring(1)));
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				break;
			case 'g':
				try {
					System.out.println(cirCleQueue.get());
				} catch (Exception e) {
					System.out.println(e.getMessage());
				};break;
			case 's':
					cirCleQueue.showQueue();
					break;
			case 'h':
				System.out.println(cirCleQueue.getHeader());
				break;
			default:
				break;
			}
		}

	}
}


class CirCleQueue{
	private int front ;
	private int rear;
	private int maxSize;
	private int[] arr;
	private int count;
	
	public CirCleQueue(int maxSize) {
		this.maxSize= maxSize;
		arr = new int[maxSize];
	}
	
	
	public boolean isFull(){
		return count==maxSize;
	}
	
	public boolean isEmpty(){
		return  count==0 ;
	}
	
	void add(int i){
		if (isFull()) {
			throw new RuntimeException("�������������");
		}else {
			if(rear==maxSize){
				rear=0;
				arr[rear]=i;
				rear++;
				count++;
			}else {
				arr[rear++]=i;
				count++;
			}
		}
	}
	
	int get(){
		if (isEmpty()) {
			throw new RuntimeException("û��Ԫ�أ��������");
		}else{
			if(front==maxSize){
				front=0;
				front++;
				count--;
				return arr[0];
			}else {
				int result = arr[front];
				front++;
				count--;
				return result;
			}
		}
	}
	
	
	int getHeader(){
		if (isEmpty()) {
			throw new RuntimeException("û��Ԫ�أ��������");
		}else {
			return arr[front];
		}
	}
	
	void showQueue(){
		System.out.println(front);
		System.out.println(rear);
		
		if (isEmpty()) {
			System.out.println("û��Ԫ�أ��������");
		}else {
			if (front<rear) {
				for (int i = maxSize-1; i >=0; i--) {
					if (i<front) {
						System.out.print("x ");
					}else if(i>=front&&i<=rear-1) {
						System.out.print(arr[i]+" ");
					}else {
						System.out.print("x ");
					}
				}
			}else{
				for (int i= rear-1; i >=0 ; i--) {
					System.out.print(arr[i]+" ");
				}
				for (int i = arr.length-1; i >=front ; i--) {
					System.out.print(arr[i]+" ");
				}
				
				for (int i = rear; i < front; i++) {
					System.out.print("x ");
				}
			}
		}
	}
	
	int size(){
		return count;
	}
}