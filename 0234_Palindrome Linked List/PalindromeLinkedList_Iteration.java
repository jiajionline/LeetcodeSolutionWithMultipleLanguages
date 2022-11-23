class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode r = reverse(slow.next);
        ListNode l = head;
        while(l != null && r!=null) {
            if(l.val != r.val) return false;
            l = l.next;
            r = r.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode p = node;
        while(p!=null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        
        return prev;
    }
}