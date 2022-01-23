public class Solution {
    public ListNode SwapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        var p = head.next;
        head.next = SwapPairs(head.next.next);
        p.next = head;
        return p;
    }
}