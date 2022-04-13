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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    
    private ListNode merge(ListNode[] lists, int l , int r) {
        if(l == r) return lists[l];
        if(l + 1 == r) {
            return merge(lists[l], lists[r]);
        }
        
        int mid = (r-l)/2 + l;
        return merge(merge(lists, l , mid), merge(lists, mid+1, r));
        
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        if(node1 == null) return node2;
        if(node2 == null) return node1;
        if(node1.val <= node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        }else{
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
    
}