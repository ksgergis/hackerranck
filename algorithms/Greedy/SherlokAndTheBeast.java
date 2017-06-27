//link https://www.hackerrank.com/challenges/sherlock-and-the-beast
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int testCases = console.nextInt();
		for (int testCase = 0; testCase < testCases; testCase++) {
			//System.out.println("\n");
			int numOfDigits = console.nextInt();
			//System.out.println("karim " + numOfDigits);

			if (numOfDigits / 3 > 0) {
				if (numOfDigits % 3 == 0) {
					System.out.println(String.format("%0" + numOfDigits + "d", 0).replace("0", "5"));
					continue;

				} else if (numOfDigits % 3 == 2) {
					int numOfFives = ((numOfDigits / 3) - 1) * 3;
					int numOfThrees = numOfDigits - numOfFives;
					if (numOfFives > 0) {
						System.out.print(String.format("%0" + numOfFives + "d", 0).replace("0", "5"));
						System.out.println(String.format("%0" + numOfThrees + "d", 0).replace("0", "3"));
						continue;
					}

				} else if(numOfDigits % 3 == 1){
					int numOfFives = ((numOfDigits)/3-3)*3;
					int numOfThrees = numOfDigits - numOfFives;
					if(numOfFives > 0){
						System.out.print(String.format("%0" + numOfFives + "d", 0).replace("0", "5"));
						System.out.println(String.format("%0" + numOfThrees + "d", 0).replace("0", "3"));
						continue;
					}
				}
			}
			if (numOfDigits / 5 > 0 && numOfDigits % 5 == 0) {
				System.out.println(String.format("%0" + numOfDigits + "d", 0).replace("0", "3"));
				continue;
			}
			System.out.println(-1);
		}
	}
}