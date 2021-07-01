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
        var stack1 = new Stack<int>();
        var stack2 = new Stack<int>();
        
        while(l1 != null){
            stack1.Push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null){
            stack2.Push(l2.val);
            l2 = l2.next;
        }
        
        ListNode header = null;
        var carry = 0;
        
        while(stack1.Count > 0 || stack2.Count > 0 || carry > 0)
        {
            var v = 0;
            if(stack1.Count > 0) v += stack1.Pop();
            if(stack2.Count > 0) v += stack2.Pop();
            v += carry;
            carry = v / 10;
            v %= 10;
            var newNode = new ListNode(v);
            newNode.next = header;
            header = newNode;
        }
        
        return header;
    }
}