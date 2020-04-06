public class Solution {
    public ListNode ReverseList (ListNode head) {
        /* iterative solution */
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }
}