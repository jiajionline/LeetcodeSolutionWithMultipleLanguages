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

        if (fast == null) slow = slow.next;

        ListNode left = head;
        ListNode right = Reverse(slow);

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

    private ListNode Reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode next = null;
        while (node != null)
        {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }

        return prev;
    }
}
