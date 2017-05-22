import java.io.*;
import java.util.*;

public class Solution {
	static HashMap<Integer, String> numbers;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int t = console.nextInt();
		for (int i = 0; i < t; i++) {

			int money = console.nextInt();
			int chocCost = console.nextInt();
			int wrappersToFreeChoc = console.nextInt();

			int chocNumber = money / chocCost;

			int result = chocNumber;
			while (chocNumber / wrappersToFreeChoc > 0) {
				result += chocNumber / wrappersToFreeChoc;
				chocNumber = chocNumber / wrappersToFreeChoc + chocNumber % wrappersToFreeChoc;
			}
			System.out.println(result);
		}

	}

}