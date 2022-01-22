public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode p = head;
        while(p!=null) {
            if(set.contains(p)) return p;
            set.add(p);
            p = p.next;
        }
        
        return null;
    }
}