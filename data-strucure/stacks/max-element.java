//question link: https://www.hackerrank.com/challenges/maximum-element

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		Stack stack = new Stack();
		for (int i = 0; i < n; i++) {
			int command = console.nextInt();
			switch (command) {
			case 1:
				int num = console.nextInt();
				stack.push(num);
				break;
			case 2:
				stack.pop();
				break;
			case 3:
				System.out.println(stack.getMax());
				break;
			}
		}
	}
}

class Stack {
	Node head;
	int currentMax;

	public void push(int num) {
		Node node = new Node();
		node.data = num;
		node.preMax = currentMax;
		node.pre = head;
		head = node;

		if (num > currentMax) {
			currentMax = num;
		}
	}

	public Node pop() {
		Node r = head;
		head = head.pre;
		currentMax = r.preMax;
		return r;
	}

	public int getMax() {
		return currentMax;
	}
}

class Node {
	int data;
	int preMax;
	Node pre;
}