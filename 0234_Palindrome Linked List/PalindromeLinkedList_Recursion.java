class Solution {
    private ListNode p1;
    public boolean isPalindrome(ListNode head) {
        p1 = head;
        return check(head);
    }
    
    private boolean check(ListNode p) {
        if(p != null) {
            if(!check(p.next)) return false;
            if( p.val != p1.val) return false;
            p1 = p1.next;
        }
        
        return true;
    }
}