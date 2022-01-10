class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p = head;
        
        while(p!=null) {
            while(p.next!=null && p.val == p.next.val)
                p.next = p.next.next;
            p = p.next;
        }
        
        return head;
    }
}