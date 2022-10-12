class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        int count = count(head);
        int c = count - n;
        
        ListNode p = preHead;
        while(c-- > 0) {
            p = p.next;
        }
        
        if(p.next != null) {
            p.next = p.next.next;
        }
        
        return preHead.next;
    }
    
    private int count(ListNode node) {
        int count = 0;
        ListNode p = node;
        while(p!=null) {
            count++;
            p = p.next;
        }
        
        return count;
    }
}