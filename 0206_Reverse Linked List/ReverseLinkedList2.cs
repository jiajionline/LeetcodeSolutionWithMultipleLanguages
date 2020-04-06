public class Solution {
   public ListNode ReverseList(ListNode head) {
        return Reverse(null, head);     
   }

    private ListNode Reverse(ListNode previous, ListNode current)
    {
        if(current == null) return previous;        
        var next = current.next;
        current.next = previous;
        return Reverse(current, next);
    }
}
