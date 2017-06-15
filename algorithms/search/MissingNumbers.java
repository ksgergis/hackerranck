import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		TreeMap<Integer, Integer> list = new TreeMap<>();
		int firstList = console.nextInt();
		for (int i = 0; i < firstList; i++) {
			int num = console.nextInt();
			list.put(num, list.getOrDefault(num, 0) + 1);
		}
		int secondList = console.nextInt();
		for (int i = 0; i < secondList; i++) {
			int num = console.nextInt();
			list.put(num, list.getOrDefault(num, 0) - 1);
		}
		for (Entry<Integer, Integer> num : list.entrySet()) {
			if (num.getValue() < 0) {
				System.out.print(num.getKey() + " ");
			}
		}
	}

}