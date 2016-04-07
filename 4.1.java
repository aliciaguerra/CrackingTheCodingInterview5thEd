/*4.1 Implement a function to check if a binary tree is balanced. For the pruposes of this question, a balanced tree 
is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one. */

/*In this question, we've been fortunate enough to be told exactly what balanced means: that for each node, the two 
subtrees differ in height by no more than one. We can implement a solution based on this definition. We can simply recurse
through the entire tree, and for each node compute the heights of each subtree.*/

public static int getHeight(TreeNode root) {
 if(root==null) return 0; //Base case
 return Math.max(getHeight(root.left), getHeight(root.left), getHeight(root.right))+1;}
 
public static boolean isBalanced(TreeNode root) {
 if(root==null) return true; //Base case
 
 int heightDiff = getHeight(root.left) - getHeight(root.right);
 if(Math.abs(heightDiff)>1) {
  return false;
 } else { //Recurse
  return isBalanced(root.left) && isBalanced(root.right);
   }
  }

/*Although this works, it is not very efficient. On each node, we recurse through its entire subtree.  This means
that getHeight is called repeatedly on the same nodes. The algorithm is O(NlogN) since each node is "touched" once
per node above it. 

We need to cut out some of the calls to getHeight.

If we inspect this method, we may notice that getHeight could actually check if the tree is balanced as the same time 
as its checking heights. What do we do when we discover that the subtree  isn't balanced? Just return -1.

This improved algorithm works by checking each subtree as we recurse from down the root. On each node, we recursively
get the heights of the left and right subtrees through the left and height methods. If the subtree is balanced, then
checkHeight will return the actual height of the subtree. If the subtree is not balanced, then checkHeight will return -1.
We will immediately break and return -1 from the current call.

The code implements this algorithm. */

public static int checkHeight(TreeNode root) {
  if(root==null) {
   return 0; //Height of 0
  }

/*Check if left is balanced.*/
int leftHeight = checkHeight(root.left);
if(leftHeight == -1) {
 return -1; //Not balanced
}

/*Check if right is balanced.*/
int rightHeight = checkHeight(root.right);
if(rightHeight = checkHeight(root.right);
return -1; //Not balanced
}

/*Check if the current node is balanced.*/
int heightDiff = leftHeight - rightHeight;
if(Math.abs(heightDiff)>1) {
 return -1; //Not balanced
} else {
 /*Return height*/
 return Math.max(leftHeight, rightHeight)+1;
    }
  }
  
 public static boolean isBalanced(TreeNode root) {
  if(checkHeight(root)==-1) {
   return flase;
  }
  else {
   return true;
  }
 }
}
