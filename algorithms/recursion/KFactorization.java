//question link https://www.hackerrank.com/challenges/k-factorization

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static ArrayList<Integer> kFactor = null;

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		int k = console.nextInt();
		int[] array = new int[k];
		for (int i = 0; i < k; i++) {
			array[i] = console.nextInt();
		}
		Arrays.sort(array);
		ArrayList<Integer> list = new ArrayList<>();
		list.add(n);
		findSmallestKFact(array, n, list);
		if (kFactor == null) {
			System.out.println("-1");
			return;
		}
		for (int i = kFactor.size() - 1; i >= 0; i--) {
			System.out.print(kFactor.get(i) + " ");
		}
	}

	private static void findSmallestKFact(int[] array, int number, ArrayList<Integer> arrayList) {
		if (number == 1) {

			if (kFactor == null || isFirstSmaller(arrayList, kFactor)) {
				kFactor = new ArrayList<>(arrayList);
			}
			return;
		}

		for (int i = 0; i < array.length; i++) {
			if (number % array[i] == 0) {
				arrayList.add(number / array[i]);
				findSmallestKFact(array, number / array[i], arrayList);
				arrayList.remove(arrayList.size() - 1);
			}
		}

	}

	private static boolean isFirstSmaller(ArrayList<Integer> firstArray, ArrayList<Integer> secondArray) {
		if (firstArray.size() < secondArray.size()) {
			return true;
		} else if (secondArray.size() < firstArray.size()) {
			return false;
		} else {
			for (int i = 0; i < firstArray.size(); i++) {
				if (firstArray.get(i) < secondArray.get(i)) {
					return true;
				} else if (secondArray.get(i) < firstArray.get(i)) {
					return false;
				}
			}
			return false;
		}

	}
}