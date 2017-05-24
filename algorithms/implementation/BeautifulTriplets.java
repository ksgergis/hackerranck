
//question link https://www.hackerrank.com/challenges/beautiful-triplets

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfItems = in.nextInt();
		int d = in.nextInt();
		HashSet<Integer> numbers = new HashSet<>();
		for (int i = 0; i < numOfItems; i++) {
			numbers.add(in.nextInt());
		}
		int numOfBeutSets = 0;
		for (int item : numbers) {
			if (numbers.contains(item + d) && numbers.contains(item + 2 * d)) {
				numOfBeutSets++;
			}
		}
		System.out.println(numOfBeutSets);
	}
}
