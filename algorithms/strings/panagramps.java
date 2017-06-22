//question link https://www.hackerrank.com/challenges/pangrams
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static int maxTcc = 0;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String sentence = console.nextLine();
		HashSet<Character> set = new HashSet<>();
		for (char ch : sentence.toCharArray()) {
			if (Character.isLetter(ch)) {
				set.add(Character.toLowerCase(ch));
			}
			if (set.size() == 26) {
				break;
			}
		}
		System.out.println(set);
		if (set.size() < 26) {
			System.out.print("not ");
		}
		System.out.println("pangram");

	}

}