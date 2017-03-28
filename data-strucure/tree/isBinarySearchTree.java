//question link: https://www.hackerrank.com/challenges/is-binary-search-tree
/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
    int data;
    Node left;
    Node right;
     }
*/
class Solution {
	
	boolean checkBST(Node root) {
		ArrayList<Integer> treeAsList = getTree(root);
		return isSorted(treeAsList);
	}

	ArrayList<Integer> getTree(Node root) {
		ArrayList<Integer> treeAsList = new ArrayList<>();
		getTreeRec(root, treeAsList);
		return treeAsList;
	}

	void getTreeRec(Node root, ArrayList<Integer> treeAsList) {
		if (root == null) {
			return;
		}
		getTreeRec(root.left, treeAsList);
		treeAsList.add(root.data);
		getTreeRec(root.right, treeAsList);

	}

	boolean isSorted(ArrayList<Integer> treeAsList) {
		int pre = Integer.MIN_VALUE;
		for (int num : treeAsList) {
			if (num <= pre) {
				return false;
			}
			pre = num;
		}
		return true;
	}
}
