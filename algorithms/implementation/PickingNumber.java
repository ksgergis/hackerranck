//question link https://www.hackerrank.com/challenges/picking-numbers

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TreeMap<Integer, Integer> a = new TreeMap<>();
		for (int a_i = 0; a_i < n; a_i++) {
			int num = in.nextInt();
			a.put(num, a.getOrDefault(num, 0) + 1);
		}
		int preNumber = -2;
		int preSetCount =0;
		int maxCount = 0;
		for (Entry<Integer, Integer> currentNumberSet: a.entrySet()) {
			int currentNumber = currentNumberSet.getKey();
			int currentSetCount = currentNumberSet.getValue();
            int tempMaxCount = currentSetCount;
			if (currentNumber == preNumber + 1) {
				tempMaxCount += preSetCount;
			}
            preNumber = currentNumber;
			preSetCount = currentSetCount;
			if (tempMaxCount > maxCount) {
				maxCount = tempMaxCount;
			}

		}
		System.out.println(maxCount);
	}
}
