class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inL, int inR, int[] postorder, int postR) {
        if(postR < 0 || inL > inR) return null;
        int rootVal = postorder[postR];
        TreeNode root = new TreeNode(rootVal);
        
        int indexRootInOrder = inL;
        
        for(;indexRootInOrder<=inR;indexRootInOrder++)
            if(inorder[indexRootInOrder] == rootVal) break;
        
        root.left = buildTree(inorder, inL, indexRootInOrder-1, postorder, postR - (inR - indexRootInOrder + 1));
        root.right = buildTree(inorder, indexRootInOrder+1, inR, postorder, postR-1);
        return root;
    }
}