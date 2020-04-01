public class Solution
{
    public ListNode RemoveElements(ListNode head, int val)
    {
        ListNode preHeader = new ListNode(-1);

        ListNode current = preHeader;
        ListNode index = head;

        while (index != null)
        {
            if(index.val == val)
            {
                current.next = index;
                current = current.next;
            }

            index = index.next;
        }

        return preHeader.next;
    }
}
