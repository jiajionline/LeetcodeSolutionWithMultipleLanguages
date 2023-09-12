class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    private TreeNode build(int[] nums, int l , int r) {
        if(l > r) return null;
        int maxIndex = max(nums, l , r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = build(nums, l, maxIndex-1);
        root.right = build(nums, maxIndex+1, r);
        return root;
    }

    private int max(int[] nums, int l , int r) {
        int max = l;
        for(int i=l+1;i<=r;i++) {
            if(nums[max] < nums[i]) max = i;
        }

        return max;
    }