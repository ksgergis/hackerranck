//question link https://www.hackerrank.com/challenges/happy-ladybugs
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		int numOfGames = console.nextInt();
		for (int i = 0; i < numOfGames; i++) {
			int numOfCells = console.nextInt();
			String game = console.next();
			boolean isSolvable = true;
			HashMap<Character, Integer> bugsCount = new HashMap<>();
			for (int cell = 0; cell < numOfCells; cell++) {
				bugsCount.put(charAt(game, cell), bugsCount.getOrDefault(charAt(game, cell), 0) + 1);
				if (charAt(game, cell) == '_' || charAt(game, cell) == charAt(game, cell + 1)
						|| charAt(game, cell) == charAt(game, cell - 1)) {
					continue;
				} else {
					isSolvable = false;
				}
			}
			// if it's already solved print that.
			if (isSolvable) {
				System.out.println("YES");
				continue;
			}
			// if its not solved and there is no empty cells, can't be solved
			if (!bugsCount.containsKey('_')) {
				System.out.println("NO");
				continue;
			}
			// if any of the bugs has only one of kind, it's unsolvable
			isSolvable = true;
			for (Entry<Character, Integer> bugFamily : bugsCount.entrySet()) {
				if (bugFamily.getKey() == '_') {
					continue;
				}
				if (bugFamily.getValue() == 1) {
					isSolvable = false;
					break;
				}
			}
			if (isSolvable) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static char charAt(String string, int index) {
		try {
			return string.charAt(index);
		} catch (Exception e) {
			return ' ';
		}
	}
}
