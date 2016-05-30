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
