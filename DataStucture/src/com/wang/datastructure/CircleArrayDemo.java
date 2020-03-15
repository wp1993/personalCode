package com.wang.datastructure;

import java.util.Scanner;

/*
 * 环形队列思路：
 * 1.front 标识下一次取出下标
 * 2.rear  下一次的新增下标,
 * 3.队列的特点是先进先出
 * 4.判断是否满：计数器count ==maxSize;
 * 5.判断是否空：count==0
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
			throw new RuntimeException("已满，不能添加");
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
			throw new RuntimeException("没有元素，请先添加");
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
			throw new RuntimeException("没有元素，请先添加");
		}else {
			return arr[front];
		}
	}
	
	void showQueue(){
		System.out.println(front);
		System.out.println(rear);
		
		if (isEmpty()) {
			System.out.println("没有元素，请先添加");
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