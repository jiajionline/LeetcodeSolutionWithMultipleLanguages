class Solution {
    private int ans = 0;
    public int longestConsecutive(TreeNode root) {
        traverse(root);
        return ans;
    }
    
    private int[] traverse(TreeNode node) {
        if(node == null) return new int[]{0,0};
        int increase = 1, decrease = 1;
        if(node.left != null) {
            int[] left = traverse(node.left);
            if(node.val == node.left.val - 1) decrease = left[1] + 1;
            else if(node.val == node.left.val + 1) increase = left[0] + 1;
        }
        
        if(node.right != null) {
            int[] right = traverse(node.right);
            if(node.val == node.right.val - 1) decrease = Math.max(decrease, right[1] + 1);
            else if(node.val == node.right.val + 1) increase = Math.max(increase, right[0] + 1);
        }
        
        ans = Math.max(ans, increase + decrease - 1);
        return new int[]{increase, decrease};
    }
}