/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        ListNode tail = null;
        ListNode newHead = null;
        
        while(p != null) {
            int count = 0;
            p = head;
            while(count < k && p != null) {
                p = p.next;
                count++;
            }
            
            if(count == k) {
                ListNode revHead = reverse(head, k);
                if(newHead == null) newHead = revHead;
                
                if(tail != null) tail.next = revHead;
                
                tail = head;
                head = p;
            }
        }
        
        if(tail != null) tail.next = head;
        
        return newHead == null ? head : newHead;
        
    }
    
    private ListNode reverse(ListNode node, int k) {
        ListNode prev = null;
        ListNode curr = node;
        while(k > 0 && curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        
        return prev;
    }
}