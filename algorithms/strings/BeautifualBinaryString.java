//question link https://www.hackerrank.com/challenges/beautiful-binary-string
import java.util.Scanner;

public class Solution {

	static int minSteps(int n, String B) {
		String needle = "010";
		int returnedCount = 0;
		for (int i = 0; i + 3 <= B.length(); i++) {
			if (B.substring(i, i + 3).equals(needle)) {
				returnedCount++;
				i = i + 2;
			}
		}
		return returnedCount;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String B = in.next();
		int result = minSteps(n, B);
		System.out.println(result);
	}
}
