/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void DeleteNode (ListNode node) {
        if (node == null || node.next == null) return;
        var next = node.next;
        node.next = next.next;
        node.val = next.val;
    }
}