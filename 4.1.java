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
