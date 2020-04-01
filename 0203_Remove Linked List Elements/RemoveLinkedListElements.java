class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode current = preHead;
        
        while(current!=null){
            if(current.next!=null && current.next.val == val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        
        return preHead.next;
        
    }
}