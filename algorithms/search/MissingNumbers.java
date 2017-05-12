//question link https://www.hackerrank.com/challenges/missing-numbers

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		HashMap<Integer, Integer> listA = new HashMap<>();
		Scanner console = new Scanner(System.in);
		int aSize = console.nextInt();
		for (int i = 0; i < aSize; i++) {
			int number = console.nextInt();
			listA.put(number, listA.getOrDefault(number, 0) + 1);
		}

		TreeMap<Integer, Integer> listB = new TreeMap<>();
		
		int bSize = console.nextInt();
		for (int i = 0; i < bSize; i++) {
			int number = console.nextInt();
			listB.put(number, listB.getOrDefault(number, 0) + 1);
		}
		
		for (int key : listB.keySet()) {
			int value = listB.get(key);
			if (!listA.containsKey(key) || listA.get(key) < value) {
				System.out.print(key + " ");
			}
		}

		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
	}
}