//https://www.hackerrank.com/challenges/making-anagrams
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	static int makingAnagrams(String s1, String s2) {

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
		return result ;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		int result = makingAnagrams(s1, s2);
		System.out.println(result);
	}
}
