public class Solution {
    public ListNode DeleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;
        var slow = head;
        var fast = head;
        var p = slow;
        
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            p = slow;
            slow = slow.next;
        }
        
        p.next = p.next.next;
        return head;
    }
}