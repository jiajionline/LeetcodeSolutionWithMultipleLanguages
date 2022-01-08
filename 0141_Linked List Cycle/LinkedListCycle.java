public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode f = head;
        ListNode s = head;
        
        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
            
            if(f == s) return true;
        }
        
        return false;
    }
}