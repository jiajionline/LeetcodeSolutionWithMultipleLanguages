namespace LeetcodePracticeCsharpVersion
{
    class RemoveDuplicatesfromSortedList
    {
        public ListNode DeleteDuplicates(ListNode head)
        {
            if (head == null || head.next == null) return head;

            var current = head;

            while (current != null)
            {
                var next = current.next;
                while(next!=null && next.val == current.val)
                {
                    next = next.next;
                }

                current.next = next;               
                current = next;
            }

            return head;
        }
    }
}
