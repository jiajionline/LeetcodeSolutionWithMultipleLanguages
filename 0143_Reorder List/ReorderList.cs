 /**
* Definition for singly-linked list.
* public class ListNode {
*     public int val;
*     public ListNode next;
*     public ListNode(int x) { val = x; }
* }
*/
public class Solution {
   public void ReorderList(ListNode head) {
       if(head == null || head.next == null) return;
       var slow = head;
       var fast = head;
       while(fast.next!=null && fast.next.next!=null){
           fast = fast.next.next;
           slow = slow.next;
       }

       var newHead = slow.next;
       slow.next = null;

       //reverse from newHead;
       ListNode previous = null;
       ListNode current = newHead;
       ListNode next = null;
       while(current!=null){
           next = current.next;
           current.next = previous;
           previous = current;
           current = next;
       }

       current = head;
       ListNode current2 = previous;

       while(current!=null && current2!=null){
           var currentNext = current.next;
           current.next = current2;
           current = currentNext;
           var currentNext2 = current2.next;
           current2.next = current;
           current2 = currentNext2;
       }
   }
}
