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
    public ListNode MiddleNode(ListNode head) {
        if(head == null) return null;
        var fast = head;
        var slow = head;
        
        while(fast !=null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}