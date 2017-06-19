//https://www.hackerrank.com/challenges/alternating-characters
import java.util.Scanner;

public class Solution {

	static int alternatingCharacters(String s) {
		int charIndex = 0;
		int result = 0;
		while (charIndex < s.length() - 1) {
			if (s.charAt(charIndex) == s.charAt(charIndex + 1)) {
				result++;
			}
			charIndex++;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			int result = alternatingCharacters(s);
			System.out.println(result);
		}
	}
}
