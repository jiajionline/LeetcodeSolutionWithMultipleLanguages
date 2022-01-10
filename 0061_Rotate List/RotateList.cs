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
    public ListNode RotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        var count = Count(head);
        k %= count;
        
        var tail = head;
        while(tail.next!=null)
            tail = tail.next;
        
        ListNode preHeader = new ListNode();
        preHeader.next = head;
        
        for(int i=1;i<=(count-k);i++)
        {
            var curr = preHeader.next;
            preHeader.next = preHeader.next.next;
            tail.next = curr;
            tail = curr;
            tail.next = null;
        }
        
        return preHeader.next;
    }
    
    private int Count(ListNode head)
    {
        var p = head;
        var count = 0;
        while(p!=null)
        {
            count++;
            p = p.next;
        }
        
        return count;
    }
}