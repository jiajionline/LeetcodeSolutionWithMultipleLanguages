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
    public void reorderList(ListNode head) {
        if (head==null||head.next==null) return;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p=head;
        while (p!=null) {
            stack.push(p); 
            p=p.next;
        }
        int count = (stack.size()-1)/2;
        p=head;
        while (count-- > 0) {
            ListNode top = stack.pop();
            ListNode tmp = p.next;
            p.next=top;
            top.next=tmp;
            p=tmp;
        }
        stack.pop().next=null;
    }
}