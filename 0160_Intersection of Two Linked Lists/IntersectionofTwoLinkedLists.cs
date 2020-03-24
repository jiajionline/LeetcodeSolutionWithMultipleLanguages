/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode GetIntersectionNode (ListNode headA, ListNode headB) {
        int a = Count (headA);
        int b = Count (headB);

        ListNode longP, shortP;
        if (a > b) {
            longP = headA;
            shortP = headB;
        } else {
            longP = headB;
            shortP = headA;
        }

        int m = Math.Abs (a - b);
        while (m > 0) {
            longP = longP.next;
            m--;
        }

        while (longP != null && shortP != null) {
            if (longP == shortP) return longP;
            else {
                longP = longP.next;
                shortP = shortP.next;
            }
        }

        return null;
    }

    private int Count (ListNode node) {
        int count = 0;
        if (node == null) return count;
        var current = node;
        count = 1;
        while (current.next != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}