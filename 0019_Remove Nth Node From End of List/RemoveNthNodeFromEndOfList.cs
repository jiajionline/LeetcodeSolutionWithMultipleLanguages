public class Solution
{
    public ListNode RemoveNthFromEnd(ListNode head, int n)
    {
        if(head == null) return head;
        
        var preHead = new ListNode(-1);
        preHead.next = head;
        
        var slow = preHead;
        var fast = preHead;

        for(int i = 0; i < n; i++)
        {
            fast = fast.next;
        }

        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return preHead.next;
    }
}
