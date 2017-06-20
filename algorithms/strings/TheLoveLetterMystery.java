//https://www.hackerrank.com/challenges/the-love-letter-mystery
import java.util.Scanner;

public class Solution {

	static int theLoveLetterMystery(String s) {
		int start = 0;
		int end = s.length() - 1;
		int result = 0;
		while (start < end) {
			result += Math.abs(s.charAt(start++) - s.charAt(end--));
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			int result = theLoveLetterMystery(s);
			System.out.println(result);
		}
	}
}
