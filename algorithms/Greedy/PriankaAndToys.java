//question link https://www.hackerrank.com/challenges/priyanka-and-toys
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		int count = 0;
		int prevWeight = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int currenttoyWeight = a[i];
			if (currenttoyWeight >= prevWeight && currenttoyWeight <= prevWeight + 4) {
				continue;
			}
			prevWeight = currenttoyWeight;
			count++;
		}
		System.out.println(count);
	}
}
