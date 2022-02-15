public class Solution {
    public TreeNode ConstructMaximumBinaryTree(int[] nums) {
        return ConstructMaximumBinaryTree(nums, 0, nums.Length-1);
    }
    
    private TreeNode ConstructMaximumBinaryTree(int[] nums, int l , int r)
    {
        if(l > r) return null;
        
        var index = FindMaxIndex(nums, l , r);
        var root = new TreeNode(nums[index]);
        root.left = ConstructMaximumBinaryTree(nums, l , index-1);
        root.right = ConstructMaximumBinaryTree(nums, index+1, r);
        return root;
    }
    
    private int FindMaxIndex(int[] nums, int l , int r)
    {
        var index = l;
        for(int i=l+1;i<=r;i++)
        {
            if(nums[i] > nums[index]) index = i;
        }
        
        return index;
    }
}