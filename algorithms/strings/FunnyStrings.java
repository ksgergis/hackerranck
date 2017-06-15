//question link https://www.hackerrank.com/challenges/funny-string

import java.util.Scanner;

public class Solution {

	static String funnyString(String s) {
		if (s.length() < 3) {
			return "Funny";
		}
		int begIndex = 1;
		int endIndex = s.length() - 1;
		while (begIndex < endIndex) {
			if (Math.abs(s.charAt(begIndex) - s.charAt(begIndex - 1)) != Math
					.abs(s.charAt(endIndex) - s.charAt(endIndex - 1))) {
				return "Not Funny";
			}
			begIndex++;
			endIndex--;
		}
		return "Funny";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			String result = funnyString(s);
			System.out.println(result);
		}
	}
}
