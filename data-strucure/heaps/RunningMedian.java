import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeSet;

public class RunningMedian {
	public static void main(String args[]) throws Exception {
		Scanner console = new Scanner(System.in);
		int listSize = console.nextInt();
		double size = 0;
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int x = 0; x < listSize; x++) {
			heap.add(console.nextInt());
			PriorityQueue<Integer> tempHeap = new PriorityQueue<>();
			size++;
			for (int tempX = 1; tempX < Math.ceil(size / (double) 2); tempX++) {
				tempHeap.add(heap.remove());
			}
			int runningMedian = heap.remove();
			System.out.println(size % 2 == 0 ? (runningMedian + heap.peek()) / (double) 2 : runningMedian);
			heap.add(runningMedian);
			heap.addAll(tempHeap);

		}
	}
}
