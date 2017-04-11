import java.io.*;
import java.util.*;

//question link https://www.hackerrank.com/challenges/qheap1
public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		Scanner console = new Scanner(System.in);
		int commands = console.nextInt();
		for (int x = 0; x < commands; x++) {
			int command = console.nextInt();
			switch (command) {
			case 1:
				heap.add(console.nextInt());
				break;
			case 2:
				heap.remove(console.nextInt());
				break;
			case 3:
				System.out.println(heap.peek());
			}
		}
	}
}
