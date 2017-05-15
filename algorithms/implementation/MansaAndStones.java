import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	static HashMap<Integer, HashSet<Integer>> numbersMap;
	public static Set<Integer> possibleNumbers;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int T = console.nextInt();
		for (int i = 0; i < T; i++) {
			possibleNumbers = new TreeSet<>();
			numbersMap = new HashMap<>();
			int numberOfStones = console.nextInt();
			int a = console.nextInt();
			int b = console.nextInt();
			calcPossibleNumbers(1, 0, numberOfStones, a, b);
			for (int number : possibleNumbers) {
				System.out.print(number + " ");
			}
			System.out.println("");
		}
	}

	private static void calcPossibleNumbers(int currentStone, int currentNumber, int numberOfStones, int a, int b) {
		if (numbersMap.containsKey(currentStone)) {
			if (numbersMap.get(currentStone).contains(currentNumber)) {
				return;
			}
		}
		if (currentStone == numberOfStones) {
			possibleNumbers.add(currentNumber);
			return;
		}
		calcPossibleNumbers(currentStone + 1, currentNumber + a, numberOfStones, a, b);
		calcPossibleNumbers(currentStone + 1, currentNumber + b, numberOfStones, a, b);
		HashSet<Integer> calculatedStones = numbersMap.getOrDefault(currentStone, new HashSet<>());
		calculatedStones.add(currentNumber);
		numbersMap.put(currentStone, calculatedStones);

	}

}