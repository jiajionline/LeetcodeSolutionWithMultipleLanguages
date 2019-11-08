/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode ConstructMaximumBinaryTree (int[] nums) {
        if (nums == null || nums.Length == 0) return null;
        return BuildTree (nums, 0, nums.Length - 1);
    }

    private TreeNode BuildTree (int[] nums, int left, int right) {
        if (left > right) return null;
        if (right > nums.Length) return null;
        if (left == right) {
            return new TreeNode (nums[left]);
        }
        //find the index of maxinum value
        var index = FindMax (nums, left, right);
        TreeNode root = new TreeNode (nums[index]);
        root.left = BuildTree (nums, left, index - 1);
        root.right = BuildTree (nums, index + 1, right);

        return root;
    }

    private int FindMax (int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}