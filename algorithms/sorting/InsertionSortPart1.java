//question link https://www.hackerrank.com/challenges/insertionsort1
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void insertIntoSorted(int[] ar) {
		int num = ar[ar.length - 1];
		int index;
		for (index = ar.length - 2; index >= 0; index--) {
			if (ar[index] > num) {
				ar[index + 1] = ar[index];
				System.out.println(Arrays.toString(ar).replaceAll("[,\\[\\]]", ""));
			} else {
				ar[index + 1] = num;
				break;
			}
		}
		if (index == -1) {
			ar[0] = num;
		}
		System.out.println(Arrays.toString(ar).replaceAll("[,\\[\\]]", ""));
	}

	/* Tail starts here */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int[] ar = new int[s];
		for (int i = 0; i < s; i++) {
			ar[i] = in.nextInt();
		}
		insertIntoSorted(ar);
	}

	private static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.println("");
	}

}
