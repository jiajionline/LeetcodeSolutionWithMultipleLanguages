class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        
        while(stack.size() > 0) {
            TreeNode node = stack.pop();
            if(node!=null) {
                if(low <= node.val && node.val <= high)
                    ans+= node.val;
                if(low < node.val) stack.push(node.left);
                if(node.val < high) stack.push(node.right);
            }
        }
        
        return ans;
    }
}