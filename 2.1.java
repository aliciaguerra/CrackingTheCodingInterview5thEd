/*2.1. Write code to remove duplicates from an unsorted linked list.*/

/*In order to remove duplicates from an unsorted linked list, we need to be able to track duplicates.
A simple hash table would work well here.*/

/*In the below solution, we simply iterate through the linked list, adding each element to a hash table.
When we discover a duplicate element, we remove the element and continue iterating. We can do all this in one pass
since we are using a linked list. */

void deleteDups(LinkedListNode n) {
 HashSet<Integer> set = new HashSet<Integer>();
 LinkedListNode previous = null;
 while(n!=null) {
   if(set.contains(n.data)) {
    previous.next = n.next;
    } else {
     set.add(n.data);
     previous = n;
       }
     n=n.next;
      }
     }
/*The above solution takes O(N) time, where N is the number of elements in the linked list.*/

/* FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?*/

/*If we don't have a buffer, we can iterate with two pointers, current which iterates through a linked
list, and runner which checks all subsequent nodes for duplicates. */

public static void deleteDups(LinkedListNode head) {
 if(head==null) return;

LinkedList current = head;
while(current!=null) {
 /*Remove all future nodes that have the same value*/
 LinkedListNode runner = current;
 while(runner.next != null) {
  if(runner.next.data == current.data) {
   runner.next = runner.next.next;
  } else {
   runner = runner.next;
   }
 }
  }
  }
 }
}

/*This code runs in O(1) space, but in O(N^2) time.*/
