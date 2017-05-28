//question link https://www.hackerrank.com/challenges/angry-children

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int K = Integer.parseInt(in.readLine());
		int[] list = new int[N];

		for (int i = 0; i < N; i++)
			list[i] = Integer.parseInt(in.readLine());

		int unfairness = Integer.MAX_VALUE;

		Arrays.sort(list);
		for (int i = K - 1; i < list.length; i++) {
			int localUnfairness = list[i] - list[i - K + 1];
			if (localUnfairness < unfairness) {
				unfairness = localUnfairness;
			}
		}

		System.out.println(unfairness);
	}
}
