//question link https://www.hackerrank.com/challenges/arithmetic-expressions
import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

	static boolean opFound = false;
	static BigInteger dev = BigInteger.valueOf(101);

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int numOfElements = console.nextInt();
		int[] elements = new int[numOfElements];
		for (int i = 0; i < numOfElements; i++) {
			elements[i] = console.nextInt();
		}
		findOp(elements, 1, BigInteger.valueOf(elements[0]), elements[0] + "");
	}

	private static void findOp(int[] elements, int i, BigInteger partialResult, String equation) {
		if (opFound) {
			return;
		}

		if (i == elements.length) {
			if (partialResult.mod(dev).equals(BigInteger.ZERO)) {
				System.out.println(equation);
				opFound = true;
			}
			return;
		}

		findOp(elements, i + 1, partialResult.multiply(BigInteger.valueOf(elements[i])), equation + "*" + elements[i]);
		findOp(elements, i + 1, partialResult.add(BigInteger.valueOf(elements[i])), equation + "+" + elements[i]);
		findOp(elements, i + 1, partialResult.subtract(BigInteger.valueOf(elements[i])), equation + "-" + elements[i]);

	}

}