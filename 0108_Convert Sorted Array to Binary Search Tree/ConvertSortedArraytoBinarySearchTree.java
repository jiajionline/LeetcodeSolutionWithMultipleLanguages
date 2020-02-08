/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums,0,nums.length-1);
    }
    
    private TreeNode buildBST(int[] nums, int l, int r){
        if(l > r) return null;
        int m = l + (r-l)/2;
        TreeNode node = new TreeNode(nums[m]);
        node.left = buildBST(nums, l, m-1);
        node.right = buildBST(nums,m+1,r);
        return node;
    }
        
}