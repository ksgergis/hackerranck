/* 
   
    class Node 
       int data;
       Node left;
       Node right;
 */
class LevelOrder {
	void LevelOrder(Node root) {
		Queue<Node> currentLevel = new LinkedList<>();
		Queue<Node> nextLevel;
		currentLevel.add(root);
		while (!currentLevel.isEmpty()) {
			nextLevel = new LinkedList<>();
			for (Node node : currentLevel) {
				System.out.print(node.data + " ");
				if (node.left != null) {
					nextLevel.add(node.left);
				}
				if (node.right != null) {
					nextLevel.add(node.right);
				}
			}
			currentLevel = nextLevel;
		}
	}
}