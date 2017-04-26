import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> scores = new ArrayList<>();
		HashSet<Integer> seenBefore = new HashSet<>();
		for (int scores_i = 0; scores_i < n; scores_i++) {
			int score = in.nextInt();
			if (seenBefore.contains(score)) {
				continue;
			}
			scores.add(score);
			seenBefore.add(score);
		}
		int m = in.nextInt();
		int previousRank = scores.size();
		for (int alice_i = 0; alice_i < m; alice_i++) {
			int aliceScore = in.nextInt();
			int rank = findRank(scores, aliceScore, previousRank);
			System.out.println(rank);
			previousRank = rank;
		}
	}

	private static int findRank(ArrayList<Integer> scores, int aliceScore, int previousRank) {

		if (aliceScore >= scores.get(0)) {
			return 1;
		}
		if (aliceScore < scores.get(scores.size() - 1)) {
			return scores.size() + 1;
		}

		int hi = previousRank;
		int lo = 0;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (scores.get(mid) == aliceScore) {
				return mid + 1;
			} else if (scores.get(mid) > aliceScore && scores.get(mid + 1) <= aliceScore) {
				return mid + 2;
			} else if (scores.get(mid) > aliceScore) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}
}
