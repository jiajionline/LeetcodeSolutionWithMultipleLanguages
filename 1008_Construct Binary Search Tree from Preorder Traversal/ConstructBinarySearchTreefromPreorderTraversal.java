class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, 0, preorder.length - 1);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        
        int index = start + 1;
        for(; index <=end && preorder[index] < preorder[start];index++);
        index--;
        
        root.left = bstFromPreorder(preorder, start + 1, index);
        root.right = bstFromPreorder(preorder, index+1, end);
        return root;
    }
}

