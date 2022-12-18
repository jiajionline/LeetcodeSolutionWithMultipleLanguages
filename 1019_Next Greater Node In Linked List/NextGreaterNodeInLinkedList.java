class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        nextLargerNodes(head, new Stack<Integer>(), list);
        int[] ans = new int[list.size()];
        for(int i=0;i<ans.length;i++) {
            ans[i] = list.get(list.size() - 1 - i);
        }
        
        return ans;
    }
    
    private void nextLargerNodes(ListNode node, Stack<Integer> stack, List<Integer> ans) {
        if(node==null) return;
        nextLargerNodes(node.next, stack, ans);
        while(!stack.isEmpty() && node.val >= stack.peek()) stack.pop();
        ans.add(stack.isEmpty() ? 0 : stack.peek());
        stack.push(node.val);
    }
}