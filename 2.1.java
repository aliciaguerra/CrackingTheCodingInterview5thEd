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
