class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
        return buildTree(inorder, 0, inorder.length - 1, postorder, postorder.length - 1, map);
    }
    
    private TreeNode buildTree(int[] inorder, int inL, int inR, int[] postorder, int postR, HashMap<Integer,Integer> map) {
        if(postR < 0 || inL > inR) return null;
        int rootVal = postorder[postR];
        TreeNode root = new TreeNode(rootVal);
        
        int indexRootInOrder = map.get(rootVal);
        
        root.left = buildTree(inorder, inL, indexRootInOrder-1, postorder, postR - (inR - indexRootInOrder + 1), map);
        root.right = buildTree(inorder, indexRootInOrder+1, inR, postorder, postR-1, map);
        return root;
    }
}