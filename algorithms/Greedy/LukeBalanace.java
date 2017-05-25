//question link https://www.hackerrank.com/challenges/luck-balance
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numOfCompt = console.nextInt();
		int maxToLose = console.nextInt();
		int result = 0;
		ArrayList<Integer> importantCompt = new ArrayList<>();
		for (int i = 0; i < numOfCompt; i++) {
			int points = console.nextInt();
			int isImport = console.nextInt();
			if (isImport == 1) {
				importantCompt.add(points);
			} else {
				result += points;
			}
		}
		Collections.sort(importantCompt, Collections.reverseOrder());
		for (int i = 0; i < maxToLose && i < importantCompt.size(); i++) {
			result += importantCompt.get(i);
		}
		for (int i = maxToLose; i < importantCompt.size(); i++) {
			result -= importantCompt.get(i);
		}
		System.out.println(result);
	}
}