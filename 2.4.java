/*2.4 Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes 
greater than or equal to x.

If this were an array, we would need to be careful about how we shifted elements. Array shifts are very expensive.

However, in a linked list, the situation is much easier. Rather than shifting and swapping elements, we can actually create
two different linked lists: one for elements less than x and one for elements greater than or equal to x.

We iterate through the linked list, inserting elements into our before listor our after list. Once we reach the end of
the linked list and have completed this splitting, we merge the two lists.

This approach is mostly "stable" in that the elements stay in their orignial order, other than the necessary movement around
the partition. 
*/

/*Pass in the head of the linked list and the value to partition around*/
public LinkedListNode partition(LinkedListNode node, int x) {
     LinkedListNode beforeStart = null;
     LinkedListNode beforeEnd = null;
     LinkedListNode afterStart = null;
     LinkedListNode afterEnd = null;
     
     /*Partition list*/
     while(node != null) {
      LinkedListNode next = node.next;
      node.next = null;
    
    if(node.data<x) {
      /*insert node into end of before list*/
     if(beforeStart==null) {
      beforeStart=node;
      beforeEnd = beforeStart;
    } else {
     beforeEnd.next = node;
     beforeEnd = node;
      }
    } else {
      /*Insert node into end of after list*/
      if(afterStart==null) {
       afterStart = node;
       afterEnd = afterStart;
    } else {
     afterEnd.next=node;
     afterEnd=node;
      }
    }
    node=next;
    }
    
    if(beforeStart==null) {
    return afterStart;
    }
    /*Merge before list and after list*/
    beforeEnd.next=afterStart;
    return beforeStart;
    }
    
/*If it bugs you to keep around so many different variables for tracking two linked lists, you're not alone. We can
make this code a bit shorter. 

If we don't care about making the elements of the list "stable" (which there's no obligation to, since the interviewer
hasn't specified that), then we can instead rearrange the elements by rearranging the elements by growing the list
at the head and tail.

In this approach, we can start a "new" list (using the existing nodes). Elements bigger than the pivot element are put at
the tail and elements smaller are put at the head. Each time we insert an element, we update either the head or the tail.*/

LinkedListNode partititon (LinkedListNode node, int x) {
     LinkedListNode head = node;
     LinkedListNode tail = node;
     
     while(node != null) {
          LinkedListNode next = node.next;
    if(node.data < x) {
         /*Inset node at the head*/
         node.next = head;
         head=node;
    } else {
         /*Insert node at the tail*/
         tail.next = node;
         tail=node;
     }
     node = next;
    }
    tail.next=null;
    //The head has changed, so we need to return it to the user
    return head;
    }

