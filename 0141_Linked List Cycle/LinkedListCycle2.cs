/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public bool HasCycle(ListNode head) {
        var s = head;
        var f = head;
        
        while(f!=null && f.next!=null){
            f = f.next.next;
            s = s.next;
            if(f == s) return true;
        }
        
        return false;
    }
}