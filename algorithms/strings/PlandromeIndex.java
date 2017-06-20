//https://www.hackerrank.com/challenges/palindrome-index
import java.util.Scanner;

public class Solution {

	static boolean palindromeIndex(String s, int beg, int end, int index) {
		while (beg < end && s.charAt(beg) == s.charAt(end)) {
			beg++;
			end--;
		}
		if (beg >= end) {
			// System.out.println("beg " + beg + "end " + end);
			System.out.println(index);
			return true;
		} else if (index == -1) {
			if (!palindromeIndex(s, beg + 1, end, beg)) {
				return palindromeIndex(s, beg, end - 1, end);
			} else {
				return true;
			}
		}
		return false;

	}
	//alternate method
	/*static boolean palindromeIndex(String s, int beg, int end, int index) {
		if (beg >= end) {
			System.out.println(index);
			return true;
		}

		if (s.charAt(beg) == s.charAt(end)) {
			return palindromeIndex(s, ++beg, --end, index);
		}

		if (index != -1) {
			return false;
		}
		if (!palindromeIndex(s, beg + 1, end, beg)) {
			return palindromeIndex(s, beg, end - 1, end);
		}
		return false;

	}*/
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			palindromeIndex(s, 0, s.length() - 1, -1);

		}
	}
}
