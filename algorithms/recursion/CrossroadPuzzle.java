//question link https://www.hackerrank.com/challenges/crossword-puzzle

package z;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		char[][] grid = new char[10][10];
		List<String> words = new LinkedList<>();
		Scanner console = new Scanner(new File("/Users/m975851/Documents/devOps/Test/testkarim.txt"));

		// read the grid
		for (int r = 0; r < 10; r++) {
			int c = 0;
			for (char a : console.next().toCharArray()) {
				grid[r][c] = a;
				c++;
			}
		}
		// read the words
		for (String word : console.next().split(";")) {
			words.add(word);
		}

		fillGrid(grid, words);
		printGrid(grid);

	}

	private static boolean fillGrid(char[][] grid, List<String> words) {
		// base case, if no more words
		if (empty(words)) {
			return true;
		}

		// get the first empty locations horizontally or vertically
		List<Slot> emptyLocation = getWordLocation(grid, r -> r + 1, c -> c, r -> r - 1, c -> c);
		if (emptyLocation == null) {
			emptyLocation = getWordLocation(grid, r -> r, c -> c + 1, r -> r, c -> c - 1);
		}

		// check all words to find a match
		for (int i = 0; i < words.size(); i++) {
			String word = words.get(i);
			// if word doesn't fit, skip it
			if (!canWordFit(grid, emptyLocation, word)) {
				continue;
			}

			// now we put the word in the grid
			fillSlots(grid, emptyLocation, word);
			// temproraly take the word for the list
			words.set(i, "");

			// fill the rest of the words
			boolean otherWordsFilled = fillGrid(grid, words);
			// if other words were filled successfully, then we are good :D
			// otherwise clean up the word that was added and put it back to the list 
			if (otherWordsFilled) {
				return true;
			} else {
				words.set(i, word);
				fillSlots(grid, emptyLocation, "-");
			}

		}
		return false;

	}

	public static boolean canWordFit(char[][] grid, List<Slot> slotsToFill, String word) {
		if (word.length() != slotsToFill.size()) {
			return false;
		}
		// if the slots has some letters already filled form intersection
		// with other word, make sure it match with the current word
		int charLoc = 0;
		for (Slot slot : slotsToFill) {
			if (grid[slot.row][slot.col] != '-' && word.charAt(charLoc) != grid[slot.row][slot.col]) {
				return false;
			}
			charLoc++;
		}
		return true;
	}

	public static void fillSlots(char[][] grid, List<Slot> slotsToFill, String word) {
		int charLoc = 0;
		for (Slot slot : slotsToFill) {
			if (!slot.filled) {
				grid[slot.row][slot.col] = word.charAt(charLoc);

			}
			if (word.length() != 1) {
				charLoc++;
			}
		}
	}

	public static boolean isDigitOrEmpty(char[][] grid, int row, int col) {
		try {
			return grid[row][col] != '+';
		} catch (Exception e) {
			return false;
		}
	}

	// return the word location, depending on the function passed, it look for
	// the word vertically or horzontilly
	public static List<Slot> getWordLocation(char[][] grid, Function<Integer, Integer> nextItemRow,
			Function<Integer, Integer> nextItemCol, Function<Integer, Integer> previousItemRow,
			Function<Integer, Integer> previousItemCol) {
		List<Slot> wordLocation = null;
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				if (grid[r][c] == '-') {
					if (isDigitOrEmpty(grid, previousItemRow.apply(r), previousItemCol.apply(c))
							|| isDigitOrEmpty(grid, nextItemRow.apply(r), nextItemCol.apply(c))) {
						wordLocation = new ArrayList<>();
						for (int cTemp = c, rTemp = r; cTemp >= 0 && rTemp >= 0; cTemp = previousItemCol
								.apply(cTemp), rTemp = previousItemRow.apply(rTemp)) {
							if (isDigitOrEmpty(grid, rTemp, cTemp)) {
								wordLocation.add(new Slot(rTemp, cTemp, grid[rTemp][cTemp] != '-'));
							} else {
								break;
							}
						}
						for (int cTemp = nextItemCol.apply(c), rTemp = nextItemRow.apply(r); cTemp < 10
								&& rTemp < 10; cTemp = nextItemCol.apply(cTemp), rTemp = nextItemRow.apply(rTemp)) {
							if (isDigitOrEmpty(grid, rTemp, cTemp)) {
								wordLocation.add(new Slot(rTemp, cTemp, grid[rTemp][cTemp] != '-'));
							} else {
								break;
							}
						}
						Collections.sort(wordLocation);
						return wordLocation;
					}
				}
			}
		}
		return wordLocation;
	}

	public static void printGrid(char[][] grid) {
		for (int r = 0; r < 10; r++) {
			for (int c = 0; c < 10; c++) {
				System.out.print(grid[r][c]);
			}
			System.out.println("");
		}
	}

	public static boolean empty(List<String> words) {
		for (String word : words) {
			if (word.trim() != "") {
				return false;
			}
		}
		return true;
	}

}

class Slot implements Comparable<Slot> {

	Integer row;
	Integer col;
	boolean filled;

	public Slot(int row, int col, boolean filled) {
		super();
		this.row = row;
		this.col = col;
		this.filled = filled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	public int compareTo(Slot o) {
		// TODO Auto-generated method stub
		return row.compareTo(o.row) == 0 ? col.compareTo(o.col) : row.compareTo(o.row);
	}

}