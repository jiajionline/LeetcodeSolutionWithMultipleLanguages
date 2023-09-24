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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revL1 = reverse(l1,null);
        ListNode revL2 = reverse(l2,null);
        ListNode head = add(revL1, revL2);
        return reverse(head,null);
    }

    private ListNode add(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode p = preHead;
        boolean carry = false;
        while(l1 != null || l2 != null || carry) {
            int v = 0;
            if(l1 != null){
                 v += l1.val;
                 l1 = l1.next;
            }
            if(l2 != null) {
                v += l2.val;
                l2 = l2.next;
            }
            if(carry) v++;
            carry = v >= 10;
            v = v % 10;
            ListNode newNode = new ListNode(v);
            p.next = newNode;
            p = p.next;
        }
        return preHead.next;
    }

    private ListNode reverse(ListNode curr, ListNode prev) {
        if(curr == null) return prev;
        var next = curr.next;
        curr.next = prev;
        return reverse(next, curr);
    }

    private ListNode reverse2(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}