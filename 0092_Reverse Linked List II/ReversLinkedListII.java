class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode prev = preHead;
        ListNode cur = prev.next;
        int i = 1;
        while(i < left) {
            prev = cur;
            cur = cur.next;
            i++;
        }
        
        ListNode node = prev;
        while(i++ <= right) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        
        node.next.next = cur;
        node.next = prev;
        return preHead.next;
    }
}