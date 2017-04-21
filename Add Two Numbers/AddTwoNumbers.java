
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        
        ListNode preHeader = new ListNode(-1);
        ListNode current = preHeader;
        int carry = 0;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        while(p1 != null || p2 != null || carry > 0){
        	
        	int value = 0;
        	if(p1 != null){
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
        
        return preHeader.next;
    }
}
