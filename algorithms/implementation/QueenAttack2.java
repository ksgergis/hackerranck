//question link https://www.hackerrank.com/challenges/queens-attack-2


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Solution {
	public static HashSet<Tile> obstacles = new HashSet<>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int rQueen = in.nextInt();
		int cQueen = in.nextInt();

		for (int a0 = 0; a0 < k; a0++) {
			int rObstacle = in.nextInt();
			int cObstacle = in.nextInt();
			obstacles.add(new Tile(rObstacle, cObstacle));
			// your code goes here
		}
		int tileCount = countTiles(rQueen, cQueen, x -> x + 1, x -> x <= n, n)
				+ countTiles(rQueen, cQueen, x -> x - 1, x -> x >= 1, n) + getColumCount(rQueen, cQueen, n);
		System.out.println(tileCount);

	}

	public static int countTiles(int rQueen, int cQueen, Function<Integer, Integer> updateRow,
			Predicate<Integer> validRow, int n) {
		int tileCount = 0;
		boolean colSameBlocked = false;
		boolean colIncBlocked = false;
		boolean colDecBlocked = false;
		for (int row = updateRow.apply(rQueen), colSame = cQueen, colInc = cQueen + 1, colDec = cQueen - 1; validRow
				.test(row); row = updateRow.apply(row), colInc++, colDec--) {
			if (colSameBlocked && colIncBlocked && colDecBlocked) {
				break;
			}

			if (!colSameBlocked && !obstacles.contains(new Tile(row, colSame))) {
				tileCount++;

			} else {
				colSameBlocked = true;
			}

			if (!colDecBlocked && colDec >= 1 && !obstacles.contains(new Tile(row, colDec))) {
				tileCount++;

			} else {
				colDecBlocked = true;
			}

			if (!colIncBlocked && colInc <= n && !obstacles.contains(new Tile(row, colInc))) {
				tileCount++;
			} else {
				colIncBlocked = true;
			}
		}
		return tileCount;
	}

	static int getColumCount(int rQueen, int cQueen, int n) {
		int tileCount = 0;
		for (int cInc = cQueen + 1; cInc <= n; cInc++) {
			if (obstacles.contains(new Tile(rQueen, cInc))) {
				break;
			}
			tileCount++;
		}

		for (int cDec = cQueen - 1; cDec >= 1; cDec--) {

			if (obstacles.contains(new Tile(rQueen, cDec))) {
				break;
			}
			tileCount++;
		}
		return tileCount;

	}
}

class Tile {
	int x;
	int y;

	public Tile(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Tile other = (Tile) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
