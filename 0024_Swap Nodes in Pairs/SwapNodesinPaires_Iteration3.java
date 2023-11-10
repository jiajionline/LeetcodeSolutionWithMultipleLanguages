class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode p = preHead;
        while(p != null && p.next != null && p.next.next != null) {
            ListNode next = p.next;
            p.next = next.next;
            next.next = p.next.next;
            p.next.next = next;
            p = next;
        }
        return preHead.next;
    }
}