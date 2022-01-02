class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<postorder.length;i++)
            map.put(postorder[i],i);
        
        return constructFromPrePost(0, 0, preorder.length, preorder, postorder, map);
        
    }
    
    private TreeNode constructFromPrePost(int preStart, int postStart, int n, int[] preorder, int[] postorder, HashMap<Integer, Integer> map) {
        if(n <= 0) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if(n == 1) return root;
        
        //locate the next left root
        int k = map.get(preorder[preStart + 1]);
        // determine the length of the left tree
        int len = k - postStart + 1;
        
        root.left = constructFromPrePost(preStart + 1, postStart, len , preorder, postorder,   map);
        root.right = constructFromPrePost(preStart + len + 1, k + 1, n - len - 1, preorder, postorder, map);
        return root;
    }
}