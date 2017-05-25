//question link https://www.hackerrank.com/challenges/recursive-digit-sum
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String number = console.nextBigInteger() + "";
		int numOfTimes = console.nextInt();
		System.out.println(getSuperDigit(number, numOfTimes));
	}

	private static String getSuperDigit(String num, int numOfTimes) {
		if (num.length() == 1) {
			return num;
		}
		return getSuperDigit(Arrays.stream(num.split("")).mapToLong(Long::valueOf).sum() * numOfTimes + "", 1);

	}
}