import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Solution {
	static int maxTcc = 0;

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner console = new Scanner(System.in);
		console.nextInt();
		String string = console.next();
		string = massageString(string);
		TreeMap<Integer, Set<Character>> charCount = getCharCount(string);
		
		for (Entry<Integer, Set<Character>> entry : charCount.entrySet()) {
			ArrayList<Character> charList = new ArrayList<>(entry.getValue());
			if (charCount.get(entry.getKey() - 1) != null) {
				charList.addAll(charCount.get(entry.getKey() - 1));
			}
			
			tCC(string, charList);
			if(maxTcc!=0){
				break;
			}
		
		}
		System.out.println(maxTcc);
	}

	static TreeMap<Integer, Set<Character>> getCharCount(String s) {
		TreeMap<Integer, Set<Character>> result = new TreeMap<>(Collections.reverseOrder());
		for (char ch : s.toCharArray()) {

			int count = s.length() - s.replace(ch + "", "").length();
			Set<Character> temp = result.getOrDefault(count, new HashSet<>());
			temp.add(ch);
			result.put(count, temp);
		}
		return result;
	}

	static String massageString(String string) {
		String temp = string;
		int countPre = string.length();
		int countAfter = 0;
		while (countAfter != countPre) {
			temp = string;
			for (int i = 1; i < string.length(); i++) {
				if (string.charAt(i) == string.charAt(i - 1)) {
					temp = temp.replace(string.charAt(i) + "", "");
				}
			}
			countAfter = temp.length();
			countPre = string.length();
			string = temp;

		}
		return temp;
	}

	static void tCC(String string, ArrayList<Character> charList) {
		for (int i = 0; i < charList.size(); i++) {
			for (int i2 = i + 1; i2 < charList.size(); i2++) {
				String temp = string.replaceAll("[^" + charList.get(i) + "" + charList.get(i2) + "]", "");
				if (checkIfTCC(temp)) {
					if (temp.length() > maxTcc) {
						maxTcc = temp.length();
					}
				}
			}
		}
		
	}

	private static boolean checkIfTCC(String string) {

		for (int i = 1; i < string.length(); i++) {
			if (string.charAt(i) == string.charAt(i - 1)) {
				return false;
			}
		}
		return true;
	}
}