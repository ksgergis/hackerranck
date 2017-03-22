/* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */
//challenge link https://www.hackerrank.com/challenges/binary-search-tree-insertion

static Node Insert(Node root,int value){
       if(root == null){
          root = new Node();
          root.data = value;
       }else if(root.data > value){
           root.left = Insert(root.left,value);
       }else{
           root.right = Insert(root.right, value);
       }
       return root;
       
    }
