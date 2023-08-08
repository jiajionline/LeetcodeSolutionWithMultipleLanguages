class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int n = count(head);
        k %= n;
        if(k == 0) return head;
        
        int steps = n - k - 1;
        ListNode p = head;
        while(steps-- > 0) {
            p = p.next;
        }

        ListNode newHead = p.next;
        p.next = null;
        p = newHead;
        while(p.next != null) p = p.next;
        p.next = head;
        return newHead;
    }

    private int count(ListNode head) {
        int count = 0;
        ListNode p = head;
        while(p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
}