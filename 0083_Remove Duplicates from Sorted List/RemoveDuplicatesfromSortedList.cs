
/**
* Definition for singly-linked list.
* public class ListNode {
*     public int val;
*     public ListNode next;
*     public ListNode(int x) { val = x; }
* }
*/
public class Solution {
   public ListNode DeleteDuplicates(ListNode head) {
       if(head == null || head.next == null) return head;
       var current = head;
       while(current!=null)
       {
           var next = current.next;
           while(next!=null && next.val == current.val)
           {
               current.next = next.next;
               next = current.next;
           }

           current = next;
       }

       return head;      
   }
}
