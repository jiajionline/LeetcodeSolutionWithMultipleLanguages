namespace LeetcodePracticeCsharpVersion
{
    class RemoveNthNodeFromEndOfList
    {
        public ListNode RemoveNthFromEnd(ListNode head, int n)
        {
            var first = head;
            var second = head;

            for(int i = 0; i < n; i++)
            {
                second = second.next;
            }

            while(second.next != null)
            {
                first = first.next;
                second = second.next;
            }

            first.next = first.next.next;

            return head;
        }
    }
}
