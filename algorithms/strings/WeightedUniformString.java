
//question link https://www.hackerrank.com/challenges/weighted-uniform-string
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	static int maxTcc = 0;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String sentence = console.nextLine();
		int numOfPre = 1;
		char pre = ' ';
		HashSet<Integer> weights = new HashSet<>();
		for (char ch : sentence.toCharArray()) {
			if (ch == pre) {
				numOfPre++;
			} else {
				numOfPre = 1;
				pre = ch;
			}
			weights.add((ch - 96) * numOfPre);

		}
	//	System.out.println(weights);
		int testCases = console.nextInt();
	//	System.out.println("test cases " + testCases);
		for (int i = 0; i < testCases; i++) {
			int num = console.nextInt();
			//System.out.println("num " + num);
			if (weights.contains(num)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}