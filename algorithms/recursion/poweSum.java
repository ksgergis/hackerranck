
//question link: https://www.hackerrank.com/challenges/the-power-sum
import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println(getPowerSum(1, 0, console.nextInt(), console.nextInt()));

	}

	static int getPowerSum(int currentNum, int currentSum, int wantedNum, int power) {
		int newSum = (int) Math.pow(currentNum, power) + currentSum;
		if (newSum == wantedNum) {
			return 1;
		} else if (newSum > wantedNum) {
			return 0;
		} else {
			return getPowerSum(currentNum + 1, newSum, wantedNum, power)
					+ getPowerSum(currentNum + 1, currentSum, wantedNum, power);
		}
	}
}