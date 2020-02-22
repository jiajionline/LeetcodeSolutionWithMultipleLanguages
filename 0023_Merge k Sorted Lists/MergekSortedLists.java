/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        if(lists.length == 0) return lists[0];
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,(a,b) -> a.val - b.val);
        ListNode pre = new ListNode(-1);
        ListNode curr = pre;
        for(ListNode n : lists){
            if(n!=null) pq.add(n);
        }
        
        while(pq.size()>0){
            ListNode node = pq.poll();
            curr.next = node;
            curr = node;
            if(node.next!=null){
                pq.add(node.next);
            }
        }
        
        return pre.next;
    }
}