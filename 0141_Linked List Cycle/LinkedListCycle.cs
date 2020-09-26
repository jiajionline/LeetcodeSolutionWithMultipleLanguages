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
        var p  = head;
        var set = new HashSet<ListNode>();
        while(p!=null){
            if(set.Contains(p)) return true;
            set.Add(p);
            p = p.next;
        }
        return false;
    }
}