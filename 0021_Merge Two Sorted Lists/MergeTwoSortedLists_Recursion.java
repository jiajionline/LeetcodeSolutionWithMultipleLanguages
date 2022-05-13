class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode preHead = new ListNode();
        ListNode curr = preHead;

        ListNode p1 = list1;
        ListNode p2 = list2;
        
        while(p1!=null && p2!=null)
        {
            if(p1.val <= p2.val){
                curr.next = p1;
                p1 = p1.next;
            }else{
                curr.next = p2;
                p2 = p2.next;
            }
            
            curr = curr.next;
        }
        
        if(p1!=null) curr.next = p1;
        if(p2!=null) curr.next = p2;
        
        return preHead.next;
    }
}