import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

//question id https://www.hackerrank.com/challenges/migratory-birds
public class Sol {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		List<String> types = new ArrayList<>();
		for (int types_i = 0; types_i < n; types_i++) {
			types.add("" + in.nextInt());
		}
		System.out.println(types.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey());
		// your code goes here
	}
}
