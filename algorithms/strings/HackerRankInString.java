//question link https://www.hackerrank.com/challenges/hackerrank-in-a-string
import java.util.Scanner;

public class Solution {
	static int maxTcc = 0;

	public static void main(String[] args) {
		String searchTerm = "hackerrank";
		Scanner console = new Scanner(System.in);
		int testCases = console.nextInt();
		for (int t = 0; t < testCases; t++) {
			String word = console.next();
			if (word.length() < searchTerm.length()) {
				System.out.println("NO");
				continue;
			}
			int searchIndex = 0;
			for (char c : word.toCharArray()) {
				if (searchIndex == searchTerm.length()) {
					break;
				}

				if (searchTerm.charAt(searchIndex) == c) {
					searchIndex++;
				}
			}

			System.out.println(searchIndex == searchTerm.length() ? "YES" : "NO");
		}
	}

}