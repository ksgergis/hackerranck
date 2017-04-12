//Question link https://www.hackerrank.com/challenges/java-lambda-expressions	
public PerformOperation is_odd() {
		return (num) -> num % 2 != 0;
	}

public PerformOperation is_prime() {

		return (num) -> {
			if (num < 2)
				return false;
			else if (num == 2)
				return true;
			else if (num % 2 == 0)
				return false;
			for (int i = 3; i * i < num; i += 2)
				if (num % i == 0)
					return false;
			return true;
		};

	}

	public PerformOperation is_palindrome() {
		return (num) -> String.valueOf(num).equals( new StringBuilder(String.valueOf(num)).reverse().toString());
	}
