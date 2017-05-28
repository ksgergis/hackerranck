import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static long getMinimumCost(int n, int k, int[] c) {
		// Complete this function
		Arrays.sort(c);
		long result = 0;
		int factor = 0;
		for (int i = n - 1, count = 1; i >= 0; i--, count++) {
			result += (factor + 1) * c[i];
			// increase the factor when all customers bought one flower each
			if (count % k == 0) {
				factor++;
			}

		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] c = new int[n];
		for (int c_i = 0; c_i < n; c_i++) {
			c[c_i] = in.nextInt();
		}
		long minimumCost = getMinimumCost(n, k, c);
		System.out.println(minimumCost);
	}
}
