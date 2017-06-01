import java.util.BitSet;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		int numOfPeople = console.nextInt();
		int numOfTopics = console.nextInt();
		BitSet[] people = new BitSet[numOfPeople];
		for (int i = 0; i < numOfPeople; i++) {
			String topics = console.next();
			BitSet topicsSet = new BitSet();
			for (int ii = 0; ii < topics.length(); ii++) {
				if (topics.charAt(ii) == '1') {
					topicsSet.set(ii);
				}
			}
			people[i] = topicsSet;
		}
		TreeMap<Integer, Integer> teamsCount = new TreeMap<>(Comparator.reverseOrder());
		for (int i = 0; i < numOfPeople; i++) {
			for (int x = i + 1; x < numOfPeople; x++) {
				BitSet firstPerson = (BitSet) people[i].clone();
				firstPerson.or(people[x]);
				int numOfTopicsTeamKnow = firstPerson.cardinality();
				teamsCount.put(numOfTopicsTeamKnow, teamsCount.getOrDefault(numOfTopicsTeamKnow, 0) + 1);
			}
		}
		Entry<Integer, Integer> mostKnownTopics = teamsCount.firstEntry();
		System.out.println(mostKnownTopics.getKey());
		System.out.println(mostKnownTopics.getValue());
	}
}
