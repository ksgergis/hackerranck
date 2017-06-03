//question link https://www.hackerrank.com/challenges/sherlock-and-array
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		outer: for (int a0 = 0; a0 < T; a0++) {
			int n = in.nextInt();
			int[] a = new int[n];
			long rightSum = 0;
			long leftSum = 0;
			int currentNum = 0;
			int preSum = 0;
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
				rightSum += a[a_i];
			}
			for (int i = 0; i < n; i++) {
				currentNum = a[i];
				rightSum -= currentNum;
				leftSum += preSum;
				if (rightSum == leftSum) {
					System.out.println("YES");
					continue outer;
				}
				//System.out.println("left sum " + leftSum + " right sum " + rightSum);
				if (leftSum > rightSum) {
					break;
				}
				preSum = currentNum;
			}
			System.out.println("NO");
		}
	}
}
