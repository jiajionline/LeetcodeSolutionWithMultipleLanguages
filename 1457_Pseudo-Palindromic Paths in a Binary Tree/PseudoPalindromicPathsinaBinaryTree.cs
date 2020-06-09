/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution
{
    public int PseudoPalindromicPaths(TreeNode root)
    {
        if (root == null) return 0;
        int[] palindromicContainer = new int[10];
        return Traverse(root, palindromicContainer);
    }

    private int Traverse(TreeNode node, int[] palindromicContainer)
    {
        if (node == null) return 0;
        var ans = 0;
        palindromicContainer[node.val]++;
        if (node.left == null && node.right == null)
        {
            if (IsPalindromic(palindromicContainer)) ans++;
        }

        ans += Traverse(node.left, palindromicContainer);
        ans += Traverse(node.right, palindromicContainer);

        palindromicContainer[node.val]--;

        return ans;
    }

    private bool IsPalindromic(int[] palindromicContainer)
    {
        int oddNumberCount = 0;
        foreach (var c in palindromicContainer)
        {
            if (c % 2 == 1) oddNumberCount++;
        }

        return !(oddNumberCount > 1);

    }
}