class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) inorderMap.put(inorder[i],i);
        return buildTree(preorder, 0, inorder, 0, inorder.length-1,inorderMap);
    }
    
    public TreeNode buildTree(int[] preorder, int preL,  int[] inorder, int inL, int inR, Map<Integer,Integer> inorderMap)
    {
        if(preL >= preorder.length || inL > inR) return null;
        
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);
        int rootIndexInOrder = inorderMap.get(rootVal);
        int leftTreeSize = rootIndexInOrder - inL;
        root.left = buildTree(preorder, preL+1, inorder, inL , rootIndexInOrder-1,inorderMap);
        root.right = buildTree(preorder, preL+1+leftTreeSize, inorder, rootIndexInOrder+1, inR,inorderMap);
        
        return root;
    }
}