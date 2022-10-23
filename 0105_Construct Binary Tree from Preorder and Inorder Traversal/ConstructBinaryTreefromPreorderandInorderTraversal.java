class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length-1);
    }
    
    public TreeNode buildTree(int[] preorder, int preL,  int[] inorder, int inL, int inR)
    {
        if(preL >= preorder.length || inL > inR) return null;
        
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInOrder = inL;
        for(;rootIndexInOrder<=inR;rootIndexInOrder++)
        {
            if(inorder[rootIndexInOrder] == rootVal) break;
        }
        
        root.left = buildTree(preorder, preL+1, inorder, inL , rootIndexInOrder-1);
        root.right = buildTree(preorder, preL+rootIndexInOrder-inL + 1, inorder, rootIndexInOrder+1, inR);
        
        return root;
    }
}