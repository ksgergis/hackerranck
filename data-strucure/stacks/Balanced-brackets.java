
//question link: https://www.hackerrank.com/challenges/balanced-brackets


import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// map the brackets opening and closing
		HashMap<Character, Character> pairs = new HashMap<>();
		pairs.put('}', '{');
		pairs.put(']', '[');
		pairs.put(')', '(');

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		for (int a0 = 0; a0 < t; a0++) {

			String s = in.next();
			// init needed vars
			boolean balanced = true;
			Stack stack = new Stack();

			for (char c : s.toCharArray()) {
				// if its closing brackets. pop the latest bracket and make sure
				// they are matching
				// if its not closing brackets, push the opening brackets to the
				// stack
				if (pairs.containsKey(c)) {
					try {
						char openedBracket = stack.pop();
						if (!pairs.get(c).equals(openedBracket)) {
							balanced = false;
							break;
						}
					} catch (NullPointerException e) {
						balanced = false;
						break;
					}
				} else {
					stack.push(c);
				}
			}
			// if the stack not empty "opened brackets never closed", or closing
			// brakcets and opening brackts didnt match, then its not balanced
			if (!stack.isEmpty() || !balanced) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}

class Stack {
	class Node {
		char data;
		Node pre;
	}

	Node head;

	public void push(char data) {
		Node node = new Node();
		node.data = data;
		node.pre = head;
		head = node;
	}

	public char pop() {
		Node r = head;
		head = head.pre;
		return r.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

}
