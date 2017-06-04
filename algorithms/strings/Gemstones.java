//question link https://www.hackerrank.com/challenges/gem-stones
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner console = new Scanner(System.in);
		int n = console.nextInt();
		HashSet<Character> gemStones = new HashSet<>();
		for (char c : console.next().toCharArray()) {
			gemStones.add(c);
		}
		for (int i = 1; i < n; i++) {
			HashSet<Character> rockStones = new HashSet<>();
			for (char c : console.next().toCharArray()) {
				rockStones.add(c);
			}
			gemStones.retainAll(rockStones);
		}
		System.out.println(gemStones.size());
	}
}