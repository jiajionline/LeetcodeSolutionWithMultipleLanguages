/**
* Definition for singly-linked list.
* public class ListNode {
*     public int val;
*     public ListNode next;
*     public ListNode(int x) { val = x; }
* }
*/
public class Solution {
    private ListNode _head;   
    private Random _rand = new Random();
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        _head = head;
    }
   
    /** Returns a random node's value. */
    public int GetRandom() {
        ListNode ret = _head;
        ListNode current = _head;
        int count = 1;
        while(current!=null)
        {
            var possibility = _rand.Next(1,count+1);
            if(possibility == count)
            {
                ret = current;
            }
            current = current.next;
            count++;
        }
 
        return ret.val;
    }
 }
 
 /**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.GetRandom();
 */
 