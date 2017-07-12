namespace LeetcodePracticeCsharpVersion
{
    class ReverseLinkedList
    {
        public ListNode ReverseList(ListNode head)
        {
            return ReverseList(head, null);
        }

        private ListNode ReverseList(ListNode current, ListNode previous)
        {
            if (current == null) return previous;
            ListNode next = current.next;
            current.next = previous;            
            return ReverseList(next, current);            
        }


        public ListNode ReverseListIteration(ListNode head)
        {
            if (head == null) return null;
            if (head.next == null) return head;
            ListNode previous = null;
            ListNode current = head;
            ListNode next = current.next;

            while(current != null)
            {
                current.next = previous;
                previous = current;
                current = next;
                if (next != null)
                {
                    next = next.next;
                }
            }

            return previous;
        }
    }
}
