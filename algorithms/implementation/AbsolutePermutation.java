//question link https://www.hackerrank.com/challenges/absolute-permutation
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int testCase = 0; testCase < testCases; testCase++) {
			int n = in.nextInt();
			int k = in.nextInt();

			List<Integer> result = newNewPerm(n, k);
			if (result == null) {
				System.out.println(-1);
			} else {
				for (int num : result) {
					System.out.print(num + " ");
				}
				System.out.println();
			}

		}

	}

	public static List<Integer> newNewPerm(int rangeEnd, int k) {
		// System.out.println("a7a " + k);
		List<Integer> result = new ArrayList<>();
		HashSet<Integer> taken = new HashSet<>();
		for (int index = 1; index <= rangeEnd; index++) {
			if (index - k > 0) {
				if (!taken.contains(index - k)) {
					taken.add(index - k);
					result.add(index - k);
					continue;
				}
			}  
			if (index + k <= rangeEnd) {
				if (!taken.contains(index + k)) {
					taken.add(index + k);
					result.add(index + k);
					continue;
				}
			}
			return null;
		}

		return result;
	}

}
