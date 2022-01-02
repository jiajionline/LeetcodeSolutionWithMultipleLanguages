public class Solution {
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        return BuildTree(preorder, 0, inorder, 0, inorder.Length-1);
    }
    
    private TreeNode BuildTree(int[] preorder, int preL, int[] inorder, int inL, int inR)
    {
        if(preL > preorder.Length - 1 || inL > inR) return null;
        var rootVal = preorder[preL];
        var root = new TreeNode(rootVal);
        
        var rootIndexInOrder = inL;
        for(;rootIndexInOrder <= inR;rootIndexInOrder++)
            if(inorder[rootIndexInOrder] == rootVal) break;
        
        root.left = BuildTree(preorder, preL+1, inorder, inL, rootIndexInOrder-1);
        root.right = BuildTree(preorder, preL + rootIndexInOrder - inL + 1, inorder, rootIndexInOrder + 1, inR);
        return root;
    }
}