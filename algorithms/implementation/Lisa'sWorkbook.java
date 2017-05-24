import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		int chapters = console.nextInt();
		int problemsPerPage = console.nextInt();
		int specialProblems = 0;
		int pageNum = 0;
		for (int i = 0; i < chapters; i++) {
			int startProbNumber = problemsPerPage * -1 + 1;
			int endProbNumber = 0;
			int currentChapterProb = console.nextInt();
			while (endProbNumber < currentChapterProb) {
				endProbNumber = endProbNumber + problemsPerPage > currentChapterProb
						? endProbNumber + currentChapterProb % problemsPerPage : endProbNumber + problemsPerPage;
				startProbNumber += problemsPerPage;
				pageNum++;
				if (pageNum >= startProbNumber && pageNum <= endProbNumber) {
					specialProblems++;
				}
			}
		}
		System.out.println(specialProblems);
	}
}