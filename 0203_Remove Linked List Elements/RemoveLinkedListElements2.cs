/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode RemoveElements(ListNode head, int val) {
        if(head == null) return null;
        var prehead = new ListNode(-1, head);
        var p = prehead;
        
        while(p!=null && p.next!=null)
        {
            if(p.next.val == val)
            {
                p.next = p.next.next;
            }else if(p.next.val != val)
            {
                p = p.next;
            }
        }
        
        return prehead.next;
    }
}