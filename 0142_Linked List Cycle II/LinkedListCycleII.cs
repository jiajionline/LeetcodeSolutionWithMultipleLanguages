public class Solution {
    public ListNode DetectCycle(ListNode head) {
        if(head == null) return null;
        var fast = head;
        var slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        
        if(fast == null || fast.next == null) return null;
        
        var p = head;
        while(p != slow){
            p = p.next;
            slow = slow.next;
        }
        
        return p;
    }
}