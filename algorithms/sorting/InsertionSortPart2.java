//question link https://www.hackerrank.com/challenges/insertionsort2
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void insertionSortPart2(int[] ar) {
		for (int index = 1; index < ar.length; index++) {
			int curIndex = index;
			while ( curIndex > 0 && ar[curIndex] < ar[curIndex - 1]) {
				swap(ar, curIndex, curIndex - 1);
				curIndex--;
			}
			System.out.println(Arrays.toString(ar).replaceAll("[,\\[\\]]", ""));
		}
	}

	private static void swap(int[] ar, int i1, int i2) {
		int temp =ar[i1];
		ar[i1] = ar[i2];
		ar[i2] = temp;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertionSortPart2(ar);

	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}
}
