using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetcodePracticeCsharpVersion
{
    class IntersectionofTwoLinkedLists
    {
        public ListNode GetIntersectionNode(ListNode headA, ListNode headB)
        {
            int a = Count(headA);
            int b = Count(headB);

            ListNode p1, p2;
            if(a > b)
            {
                p1 = headA;
                p2 = headB;
            }
            else
            {
                p1 = headB;
                p2 = headA;
            }

            int m = Math.Abs(a - b);
            while(m > 0)
            {
                p1 = p1.next;
                m--;
            }

            while(p1 !=null && p2 != null)
            {
                if (p1 == p2) return p1;
                else
                {
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }

            return null;
        }

        private int Count(ListNode node)
        {
            int count = 0;
            if (node == null) return count;
            var current = node;
            count = 1;
            while (current.next != null)
            {
                count++;
                current = current.next;
            }

            return count;
        }
    }
}
