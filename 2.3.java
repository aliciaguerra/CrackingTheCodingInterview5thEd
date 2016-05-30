//2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
/*In this problem, you are not given access to the head of the linked list. You only have access to that node. The solution 
is simply to copy the data from the next node over to the current node, and then to declare the next node.*/

public static boolean deleteNode(LinkedListNode n) {
 if(n==null || n.next==null) {
  return false; //Failure
  }
  
LinkedListNode next = n.next;
n.data=next.data;
n.next=next.next;
return true;
}

/* Note that this problem cannot be solved if the node to be deleted is the last node in the linked list. That's ok - 
your interviewer wants you to point out that out, consider marking the code as a dummy. */
