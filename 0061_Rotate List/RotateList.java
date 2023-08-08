class Solution {
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null)
            return null;
        int count = 1; // since we are already at head node
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null){
            count++;
            fast = fast.next;
        }

        k %= count;
        int steps = count - k - 1;
        while(steps-- > 0) slow = slow.next;
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
}