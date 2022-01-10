/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
public static ListNode rotateRight(ListNode head, int k) {
	if(head==null)
        return null;
	int size = 1; // since we are already at head node
	ListNode fast=head;
	ListNode slow = head;
	
	while(fast.next!=null){
	    size++;
	    fast = fast.next;
	}
	
	for(int i=size-k%size;i>1;i--) // i>1 because we need to put slow.next at the start.
		slow = slow.next;
	
	fast.next = head;
	head = slow.next;
	slow.next = null;
	
	return head;
}
}