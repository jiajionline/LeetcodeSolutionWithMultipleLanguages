namespace LeetcodePracticeCsharpVersion
{
    public class AddTwoNumbersQuestion
    {
        public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
        {
            if (l1 == null && l2 == null) return null;

            ListNode preHead = new ListNode(-1);
            ListNode current = preHead;
            ListNode p1 = l1;
            ListNode p2 = l2;
            int carry = 0;
            while(p1 != null || p2 != null || carry > 0)
            {
                int value = 0;
                if (p1 != null)
                {
                    value += p1.val;
                    p1 = p1.next;
                }

                if(p2 != null){
                    value += p2.val;
                    p2 = p2.next;
                }

                value += carry;

                carry = value / 10;
                value = value % 10;

                ListNode temp = new ListNode(value);

                current.next = temp;
                current = temp;
                
            }

            return preHead.next;
        }
    }
}
