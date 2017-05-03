//question link https://www.hackerrank.com/challenges/password-cracker
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static HashMap<String, Boolean> foundMatch;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner console = new Scanner(System.in);
		int testCases = console.nextInt();
		for (int t = 0; t < testCases; t++) {
			foundMatch = new HashMap<>();
			int passwordsNumber = console.nextInt();
			List<String> passwords = new LinkedList<>();
			for (int p = 0; p < passwordsNumber; p++) {
				passwords.add(console.next());
			}
			String loginAttempt = console.next();
			Stack<String> usedPasswordsToLogin = new Stack<>();
			checkIfValidAttempt(loginAttempt, passwords, usedPasswordsToLogin);
			if (usedPasswordsToLogin.isEmpty()) {
				System.out.println("WRONG PASSWORD");
			} else {
				while (!usedPasswordsToLogin.isEmpty()) {
					System.out.print(usedPasswordsToLogin.pop() + " ");
				}
				System.out.println("");
			}

		}
	}

	private static boolean checkIfValidAttempt(String loginAttempt, List<String> passwords,
			Stack<String> usedPasswordsToLogin) {
		if (foundMatch.containsKey(loginAttempt)) {
			return foundMatch.get(loginAttempt);
		}
		if (loginAttempt.length() == 0) {
			return true;
		}
		for (String password : passwords) {
			if (loginAttempt.startsWith(password)) {
				if (checkIfValidAttempt(loginAttempt.substring(password.length()), passwords, usedPasswordsToLogin)) {
					usedPasswordsToLogin.push(password);
					foundMatch.put(loginAttempt, true);
					return true;
				}
			}
		}
		foundMatch.put(loginAttempt, false);
		return false;
	}
}