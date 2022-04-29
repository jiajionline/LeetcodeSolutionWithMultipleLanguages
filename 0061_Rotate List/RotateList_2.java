class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode p = head;
        
        int c = count(head);
        k %= c;
        
        if( k == 0) return head;
        k = c - k;
        
        
        while(--k > 0) {
            p = p.next;    
        }
        
        ListNode tail = p;
        while(tail.next != null) {
            tail = tail.next;
        }
        
        ListNode newHead = p.next;
        p.next = null;
        tail.next = head;
        
        return newHead;
        
    }
    
    private int count(ListNode node) {
        int c = 0;
        ListNode p = node;
        while(p!=null) {
            p= p.next;
            c++;
        }
        return c;
    }
}