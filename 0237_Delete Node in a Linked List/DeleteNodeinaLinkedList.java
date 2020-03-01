/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        ListNode next = node.next;
        node.next = next.next;
        node.val = next.val;
    }
}
