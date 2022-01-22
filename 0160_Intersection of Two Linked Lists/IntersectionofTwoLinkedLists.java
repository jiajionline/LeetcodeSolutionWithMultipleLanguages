public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = count(headA);
        int countB = count(headB);
        
        ListNode p1 = countA >= countB ? headA : headB;
        ListNode p2 = countA < countB ? headA : headB;
        
        for(int i=0;i<Math.abs(countA - countB);i++)
            p1 = p1.next;
        
        while(p1!=null && p2!=null) {
            if(p1 == p2)  return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return null;
    }
    
    private int count(ListNode node) {
        int count = 0;
        ListNode p = node;
        while(p!=null) {
            count++;
            p = p.next;
        }
        
        return count;
    }
}