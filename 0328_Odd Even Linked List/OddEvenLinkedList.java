class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        
        ListNode p1 = head;
        
        while(p1.next !=null) {
            ListNode next = p1.next;
            p1.next = next.next;
            p1 = next;
        }
        
        p1 = oddHead;
        while(p1.next != null) p1 = p1.next;
        p1.next = evenHead;
        
        return oddHead;
    }
}