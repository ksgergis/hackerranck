//https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] a = new long[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = in.nextLong();
		}
		Arrays.sort(a);
		long minDif = Long.MAX_VALUE;
		for (int i = 1; i < a.length; i++) {
			if (Math.abs(a[i] - a[i - 1]) < minDif) {
				minDif = Math.abs(a[i] - a[i - 1]);
			}
		}
		System.out.println(minDif);
	}
}
