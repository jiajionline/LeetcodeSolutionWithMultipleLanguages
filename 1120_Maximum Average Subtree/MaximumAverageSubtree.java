class Solution {
    private double ans = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        traverse(root);
        return ans;
    }
    
    // res[0] is count, res[1] is sum
    private int[] traverse(TreeNode node) {
        int[] res = new int[2];
        if(node == null) return res;
        int[] left = traverse(node.left);
        int[] right = traverse(node.right);
        int leftCount = left[0], rightCount = right[0], leftSum = left[1], rightSum = right[1];
        int count = 1 + leftCount + rightCount;
        int sum = node.val + leftSum + rightSum;
        res[0] = count;
        res[1] = sum;
        ans = Math.max(ans, (double)sum / (double)count);
        return res;
    }
}