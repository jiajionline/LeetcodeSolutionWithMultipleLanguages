class Solution {
    public int pairSum(ListNode head) {
        int ans = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while(p!=null) {
            stack.push(p);
            p = p.next;
        }
        
        p = head;
        
        while(p!=null && stack.size() > 0) {
            ans = Math.max(ans, p.val + stack.pop().val);
            p = p.next;
        }
        
        return ans;
    }
}