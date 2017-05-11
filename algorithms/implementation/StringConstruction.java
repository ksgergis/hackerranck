//question link https://www.hackerrank.com/challenges/string-construction
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			String s = in.next();
			HashSet<Character> pChars = new HashSet<>();
			int cost = 0;
			for (char currentChar : s.toCharArray()) {
				if (!pChars.contains(currentChar)) {
					pChars.add(currentChar);
					cost++;
				}
			}
			System.out.println(cost);

		}
	}
}
