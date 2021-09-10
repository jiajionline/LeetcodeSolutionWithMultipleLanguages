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
    public bool IsPalindrome(ListNode head)
    {
        if (head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode middle = slow.next;
        slow.next = null;

        ListNode prev = null;
        ListNode current = middle;
        ListNode next = null;

        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        ListNode left = head;
        ListNode right = prev;

        while (left != null && right != null)
        {
            if (left.val != right.val)
            {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
