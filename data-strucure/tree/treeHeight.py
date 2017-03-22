#challenge link: https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree?h_r=next-challenge&h_v=zen
#getting tree height
#python 3

# Enter your code here. Read input from STDIN. Print output to STDOUT
'''
class Node:
      def __init__(self,info): 
          self.info = info  
          self.left = None  
          self.right = None 
           

       // this is a node of the tree , which contains info as data, left , right
'''
def height(root):
    return getHight(root,0)

def getHight(node, height):
    if(node == None or (node.left == None and node.right == None)):
        return height
    return max(getHight(node.left,height),getHight(node.right,height))+1