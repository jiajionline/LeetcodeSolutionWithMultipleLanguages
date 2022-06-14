class Solution {
    private int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) inorderMap.put(inorder[i],i);
        return build(preorder, inorder, inorderMap, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, Map<Integer,Integer> inorderMap, int inB, int inE) {
        if(inB > inE) return null;
        TreeNode node = new TreeNode(preorder[preIndex++]);
        int inIndex = inorderMap.get(node.val);
        node.left = build(preorder, inorder,inorderMap, inB, inIndex-1);
        node.right = build(preorder, inorder,inorderMap, inIndex+1, inE);
        return node;
    }
}