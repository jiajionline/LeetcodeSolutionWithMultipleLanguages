public class Solution {
    public ListNode partition(ListNode head, int x) {
        if( head==null || head.next== null) return head;
        ListNode preLessThanXHead = new ListNode(-1);
        ListNode preMoreThanXHead = new ListNode(-1);
        ListNode p1 = preLessThanXHead;
        ListNode p2 = preMoreThanXHead;

        ListNode p = head;
        while(p != null) {
            if(p.val < x) {
                p1.next = p;
                p1 = p1.next;
                p = p.next;
                p1.next = null;
            }else{
                p2.next = p;
                p2 = p2.next;
                p = p.next;
                p2.next = null;
            }
            
        }

        p1.next = preMoreThanXHead.next;
        return preLessThanXHead.next;
    }
    
}