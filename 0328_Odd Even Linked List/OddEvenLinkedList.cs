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
public class Solution
{
    public ListNode OddEvenList(ListNode head)
    {
        if (head == null || head.next == null) return head;
        var p1 = head;
        var head2 = head.next;
        var p2 = head.next;

        while (p1 != null && p2 != null)
        {
            p1.next = p2.next;
            p1 = p2;
            p2 = p2.next;
        }

        p1 = head;
        while (p1 != null && p1.next != null)
        {
            p1 = p1.next;
        }

        p1.next = head2;

        return head;
    }
}