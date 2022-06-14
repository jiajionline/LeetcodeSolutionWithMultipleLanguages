class Solution {
    private int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        Map<Integer,Integer> inorderIndex = new HashMap<>();
        for(int i=0;i<inorder.length;i++) inorderIndex.put(inorder[i], i);
        return build(inorder, postorder,inorderIndex, 0, inorder.length-1);
    }
    
    private TreeNode build(int[] inorder, int[] postorder, Map<Integer,Integer> inorderIndex, int inL, int inR) {
        if(inL > inR) return null;
        int val = postorder[postIndex--];
        TreeNode node = new TreeNode(val);
        int inIndex = inorderIndex.get(val);
        node.right = build(inorder, postorder, inorderIndex, inIndex+1, inR);
        node.left = build(inorder, postorder, inorderIndex, inL, inIndex-1);
        return node;
    }
}