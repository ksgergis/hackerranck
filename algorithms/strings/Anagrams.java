//https://www.hackerrank.com/challenges/anagram
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	static int anagaram(String s) {
		// Complete this function
		if (s.length() % 2 != 0) {
			return -1;
		}
		String s1 = s.substring(0, s.length() / 2);
		String s2 = s.substring(s.length() / 2);
		Map<Character, Integer> charCount = new HashMap<>();
		for (char charch : s1.toCharArray()) {
			charCount.put(charch, charCount.getOrDefault(charch, 0) + 1);
		}
		for (char charch : s2.toCharArray()) {
			charCount.put(charch, charCount.getOrDefault(charch, 0) - 1);
		}
		int result = 0;
		for (int count : charCount.values()) {
			result += Math.abs(count);
		}
		return result/2;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			int result = anagaram(s);
			System.out.println(result);
		}
	}
}
