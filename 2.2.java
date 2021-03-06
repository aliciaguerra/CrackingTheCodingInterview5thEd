/*2.2 Implement an algorithm to find the kth to last element of a singly linked list.*/

/*We will approach this problem both recursively and non-recursively. Remember that recursive solutions
are often cleaner but less optimal. For example, in this problem, the recursive implementation is about half the length
of the iterative solution, but also takes O(N) space, where N is the number of elements in the linked list.

Note that for this solution, we have defined k such that passing in k=1 would return the last element, k=2 would 
return to the second to last element, and so on. It is equally acceptable to define k such that k=0 would return
the last element.*/

/*Solution: If linked list size is known
If the size of the linked list is known, then the kth to last element is the (length-k)th element. We can just
iterate through the linked list to find this element. Because this element is so trivial, we can almost be sure
that this is not what the interviewer intended.*/

/*Solution #2: Recursive
This algorithm recurses through the linked list. When it hits the end, the method passes back a counter set to 0.
Each parent call adds 1 to this counter. When the counter equals k, we know we have reached the kth to last element
of the linked list.

Implementing this is short and sweet - provided we have a way of "passing back" an integer value through a stack.
Unfortunately, we can't pass back a node and a counter using normal return statements. So, how do we handle this?
*/

/*Approach A: Don't Return the Element
One way to do this is to change the problem to simply printing the kth to last element. Then, we can pass back the value 
of the counter simply through return values.*/

public static int nthtoLast(LinkedListNode head, int k) {
 if(head==null) {
  return 0; }
  int i = nthToLast(head,next,k)+1;
  if(i==k) {
   System.out.println(head.data);
  }
  return i;
}
/*Of course, this is only a valid solution if the interviewer says it's valid.*/

/*Approach B: Use C/C++
A second way to solve this is to use C++ and to pass values by reference. This allows us to return the node
value, but also update the counter by passing a pointer to it.*/

node* nthToLast(node* head, int k, int& i) {
 if(head==null) {
  return NULL;
 }
 node * nd = nthToLast(head->next,k,i);
 1 = i+1;
 if(i==k) {
  return head;
 }
 return nd;
}
 }
 }
}

/* Approach C: Create a Wrapper Class
We described earlier that the issue was that we couldn't simultaneously return a counter and an index. If we wrap
the counter value with a simple class (or even a single element array), we can mimic by passing reference.*/

public class IntWrapper {
 public int value = 0;
}

LinkedListNode nthToLastR2(LinkedListNode head, int k, IntWrapper i) {
 
}
}
