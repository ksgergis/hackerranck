//question url:https://www.hackerrank.com/challenges/swap-nodes-algo

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Node root = initData(console);

		int numberOfSwaps = console.nextInt();
		for (int i = 0; i < numberOfSwaps; i++) {
			int level = console.nextInt();
			swap(root, level, 1);
			traverse(root);
			System.out.println("");
		}

	}

	// read the tree from stdin
	static Node initData(Scanner console) {

		int linesToRead = console.nextInt();
		Queue<Node> q = new LinkedList<>();
		Node root = new Node();
		root.data = 1;
		q.add(root);

		for (int i = 0; i < linesToRead; i++) {
			Node currentParent = q.poll();
			int left = console.nextInt();
			int right = console.nextInt();

			if (left != -1) {
				Node node = new Node();
				node.data = left;
				q.add(node);
				currentParent.left = node;
			}

			if (right != -1) {
				Node node = new Node();
				node.data = right;
				q.add(node);
				currentParent.right = node;
			}
		}
		return root;
	}

	// swap function
	static void swap(Node node, int level, int currentLevel) {
		if (node == null) {
			return;
		}
		if (currentLevel % level == 0) {
			Node tempRight = node.right;
			node.right = node.left;
			node.left = tempRight;
		}
		swap(node.left, level, currentLevel + 1);
		swap(node.right, level, currentLevel + 1);

	}

	// in-order traversal
	static void traverse(Node node) {
		if (node == null) {
			return;
		}
		traverse(node.left);
		System.out.print(node.data + " ");
		traverse(node.right);
	}
}

class Node {
	int data;
	Node left;
	Node right;
}