//question link: https://www.hackerrank.com/challenges/marcs-cakewalk
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] calories = new Integer[n];
		for (int calories_i = 0; calories_i < n; calories_i++) {
			calories[calories_i] = in.nextInt();
		}
		Arrays.sort(calories, Collections.reverseOrder());
		//System.out.println(Arrays.toString(calories));
		long miles = 0;
		for (int i = 0; i < calories.length; i++) {
			miles += calories[i] * Math.pow(2, i);
		}
		System.out.println(miles);
		// your code goes here
	}
}
