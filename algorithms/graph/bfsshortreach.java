
//question link https://www.hackerrank.com/challenges/bfsshortreach
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner console = new Scanner(System.in);
		int q = console.nextInt();
		for (int qI = 0; qI < q; qI++) {
			int nodes = console.nextInt();
			int numOfEdges = console.nextInt();
			Graph graph = new Graph(nodes + 1);
			for (int i = 0; i < numOfEdges; i++) {
				graph.addEdge(console.nextInt(), console.nextInt());
			}

			int[] pathLength = new int[nodes + 1];
			boolean[] visited = new boolean[nodes + 1];
			int startNode = console.nextInt();
			getShortestPath(graph, startNode, pathLength, visited);
			for (int i = 1; i <= nodes; i++) {
				if (i == startNode) {
					continue;
				}
				System.out.print((pathLength[i] == 0 ? -1 : pathLength[i]) + " ");
			}
			System.out.println("");
		}

	}

	private static void getShortestPath(Graph g, int node, int[] pathLength, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		int length = 6;
		Queue<Integer> nextRowQueue;
		do{
			nextRowQueue = new LinkedList<>();
			while (!queue.isEmpty()) {	
				int currentNode = queue.poll();
				for (int adjNode : g.getAdj(currentNode)) {
					if (!visited[adjNode]) {
						visited[adjNode] = true;
						pathLength[adjNode] = length;
						nextRowQueue.add(adjNode);
					}
				}
			
			}
			queue = nextRowQueue;
			length += 6;
		}while(!nextRowQueue.isEmpty());
	}
}

class Graph {
	private static final int nodesSize = 0;
	List<Integer>[] nodes;

	public Graph(int nodesSize) {
		nodes = new List[nodesSize];
		for (int nodeId = 0; nodeId < nodesSize; nodeId++) {
			nodes[nodeId] = new ArrayList<>();
		}
	}

	public void addEdge(int u, int v) {
		nodes[u].add(v);
		nodes[v].add(u);

	}

	public List<Integer> getAdj(int u) {
		return nodes[u];
	}

}
