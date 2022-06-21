class Solution {
    private int ans = 0;
    public int longestZigZag(TreeNode root) {
        traverse(root);
        return ans == 0 ? 0 : ans - 1;
    }
    
    private int[] traverse(TreeNode node) {
        int[] res = new int[2];  // [leftSum, rightSum]
        if(node == null) return res;
        int[] left = traverse(node.left);
        int[] right = traverse(node.right);
        res[0] = left[1] + 1;
        res[1] = right[0] + 1;
        ans = Math.max(ans, Math.max(res[0], res[1]));
        return res;
    }
}