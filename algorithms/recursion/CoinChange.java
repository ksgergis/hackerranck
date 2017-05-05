
//question link  https://www.hackerrank.com/challenges/coin-change

import java.util.Scanner;

public class Solution {

	static long[][] calculated;

	private static long calculator(long[] coins, int numToUse, int sum) {
		if (sum == 0) {
			return 1;
		} else if (sum < 0) {
			return 0;
		} else if (numToUse <= 0) {
			return 0;
		} else {
			if (calculated[sum][numToUse] == -1) {
				calculated[sum][numToUse] = calculator(coins, numToUse - 1, sum)
						+ calculator(coins, numToUse, (int) (sum - coins[numToUse - 1]));
			}
			return calculated[sum][numToUse];
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		calculated = new long[n + 1][m + 1];
		for (int x = 0; x < n + 1; x++)
			for (int i = 0; i < m + 1; i++) {
				calculated[x][i] = -1;
			}
		long[] c = new long[m];
		for (int c_i = 0; c_i < m; c_i++) {
			c[c_i] = in.nextLong();
		}
		// Print the number of ways of making change for 'n' units using coins
		// having the values given by 'c'
		long ways = calculator(c, m, n);
		System.out.println(ways);
	}
}
