/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
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
            
    public ListNode reverseKGroup(ListNode head, int k) {
        
        int count = 0;
        ListNode ptr = head;
        
        while (count < k && ptr != null) {
            ptr = ptr.next;
            count++;
        }
            
        if (count == k) {
            ListNode reversedHead = reverse(head, k);
            head.next = this.reverseKGroup(ptr, k);
            return reversedHead;
        }
            
        return head;
    }
}