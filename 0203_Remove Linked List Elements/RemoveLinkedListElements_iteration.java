class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHeader = new ListNode(-1);
        preHeader.next = head;
        ListNode p = preHeader;
        
        while(p!=null) {
            while(p.next != null && p.next.val == val) {
                p.next = p.next.next;
            }
            p = p.next;
        }
        
        return preHeader.next;
        
    }
}