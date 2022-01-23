class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode p = preHead;
        
        while(p!=null)
        {
            ListNode p1 = p.next;
            if(p1 == null) break;
            ListNode p2 = p1.next;
            if(p2 == null) break;
            p.next = p2;
            ListNode p3 = p2 != null ? p2.next : null;
            if(p2!=null) p2.next = p1;
            p1.next = p3;
            p = p1;
        }
        
        return preHead.next;
    }
}