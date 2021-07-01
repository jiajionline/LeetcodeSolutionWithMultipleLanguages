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
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        var p1 = Reverse(l1, null);
        var p2 = Reverse(l2, null);
        var p = AddTwo(p1,p2);
        return Reverse(p, null);
        
    }
    
    private ListNode Reverse(ListNode current, ListNode previous)
    {
        if(current == null) return previous;
        var next = current.next;
        current.next = previous;
        return Reverse(next, current);
    }
    
    private ListNode AddTwo(ListNode l1, ListNode l2)
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