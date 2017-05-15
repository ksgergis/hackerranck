//question link https://www.hackerrank.com/challenges/manasa-and-stones
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	static HashMap<Integer, HashMap<Integer, Boolean>> numbersMap;
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
			if (numbersMap.get(currentStone).containsKey(currentNumber)) {
				return;
			}
		}
		if (currentStone == numberOfStones) {
			possibleNumbers.add(currentNumber);
			return;
		}
		calcPossibleNumbers(currentStone + 1, currentNumber + a, numberOfStones, a, b);
		calcPossibleNumbers(currentStone + 1, currentNumber + b, numberOfStones, a, b);
		HashMap<Integer, Boolean> calculatedStones = numbersMap.getOrDefault(currentStone, new HashMap<>());
		calculatedStones.put(currentNumber, true);
		numbersMap.put(currentStone, calculatedStones);

	}

}