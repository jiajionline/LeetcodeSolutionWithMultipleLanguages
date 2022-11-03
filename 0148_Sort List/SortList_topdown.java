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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode fastHead = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(fastHead));
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        if(node1.val <= node2.val){
            node1.next = merge(node1.next, node2);
            return node1;
        }else{
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}

/**

2->4  1->3->null
   S  F
1->2->3->4

*/