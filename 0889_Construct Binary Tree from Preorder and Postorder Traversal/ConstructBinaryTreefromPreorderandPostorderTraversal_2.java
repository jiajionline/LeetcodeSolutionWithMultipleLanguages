class Solution {
    private int preStart = 0;
    private int[] preorder;
    private int[] postorder;
    private int N;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        N = preorder.length;
        Map<Integer,Integer> postorderIndex = new HashMap<>();
        for(int i=0;i<postorder.length;i++) postorderIndex.put(postorder[i], i);
        return constructFromPrePost(postorderIndex, 0, postorder.length - 1);
        
    }
    
    private TreeNode constructFromPrePost(Map<Integer,Integer> postorderIndex, int postL, int postR) {
        if(preStart >= N || postL > postR) return null;
        TreeNode node = new TreeNode(preorder[preStart++]);
        if(preStart == N || postL == postR) return node;
        int postIndex = postorderIndex.get(preorder[preStart]);
        node.left = constructFromPrePost(postorderIndex, postL, postIndex);
        node.right = constructFromPrePost(postorderIndex, postIndex+1, postR-1);
        return node;
    }
}