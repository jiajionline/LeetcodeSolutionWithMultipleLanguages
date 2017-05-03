
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head){
    	if(head == null || head.next == null) return head;
    	ListNode current = head;
    	
    	while(current!=null){
    		ListNode next = current.next;
    		
    		while(next!=null && next.val == current.val){
    			next = next.next;
    		}
    		
    		current.next = next;
    		current = next;
    	}
    	
    	return head;
    }
}
