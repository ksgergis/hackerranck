
//question link https://www.hackerrank.com/challenges/icecream-parlor
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		int trips = console.nextInt();
		for (int trip = 0; trip < trips; trip++) {
			HashMap<Integer, Integer> flavors = new HashMap<>();
			int money = console.nextInt();
			int numberOfFlavors = console.nextInt();
			for (int flovorId = 1; flovorId <= numberOfFlavors; flovorId++) {
				int cost = console.nextInt();
				int neededFlavorPrice = money - cost;
				if (flavors.containsKey(neededFlavorPrice)) {
					System.out.println(flavors.get(neededFlavorPrice) + " " + flovorId);
					console.nextLine();
					break;
				}
				flavors.put(cost, flovorId);
			}
		}
	}

}