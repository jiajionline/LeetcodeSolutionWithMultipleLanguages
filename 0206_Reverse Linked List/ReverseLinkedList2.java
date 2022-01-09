class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }
    
    private ListNode reverseList(ListNode curr, ListNode prev)
    {
        if(curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseList(next, curr);
    }
}