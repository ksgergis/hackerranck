//question link https://www.hackerrank.com/challenges/separate-the-numbers
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		outer: for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			for (int len = 1; len <= s.length() / 2; len++) {
				if (len > 1 && s.startsWith("0")) {
					break;
				}
				if (checkSeq(Long.valueOf(s.substring(0, len)), s)) {
					System.out.println("YES " + Long.valueOf(s.substring(0, len)));
					continue outer;
				}
			}
			System.out.println("NO");
		}
	}

	public static boolean checkSeq(long num, String seq) {
		int startIndex = 0;
		String numString = String.valueOf(num);
		int endIndex = numString.length();
		while (startIndex < seq.length()) {
			if (endIndex > seq.length() || !seq.substring(startIndex, endIndex).equals(numString)) {
				return false;
			}
			num++;

			numString = String.valueOf(num);
			startIndex = endIndex;
			endIndex = startIndex + numString.length();
		}
		return true;

	}

}
