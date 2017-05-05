//question link https://www.hackerrank.com/challenges/minimum-distances

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int A[] = new int[n];
		HashMap<Integer, Integer> arrayItemLocation = new HashMap<>();
		int minDif = Integer.MAX_VALUE;
		for (int A_i = 0; A_i < n; A_i++) {
			int number = in.nextInt();
			if (arrayItemLocation.containsKey(number)) {
				int tempDif = A_i - arrayItemLocation.get(number);
				if (tempDif < minDif) {
					minDif = tempDif;
				}
			}
			arrayItemLocation.put(number, A_i);
		}
		System.out.println(minDif == Integer.MAX_VALUE ? -1 : minDif);
	}
}
