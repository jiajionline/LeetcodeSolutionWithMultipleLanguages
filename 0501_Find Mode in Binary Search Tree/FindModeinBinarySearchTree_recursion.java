class Solution {
    private List<Integer> modeList = new ArrayList<>();
    private int maxCount = 0;
    private int currMode = Integer.MIN_VALUE;
    private int currCount = 0;
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        inOrder(root);
        
        int[] ans = new int[modeList.size()];
        for(int i=0;i<ans.length;i++) ans[i] = modeList.get(i);
        
        return ans;
    }
    
    private void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        
        if(node.val != currMode) {
            currMode = node.val;
            currCount = 0;
        }
        
        currCount++;
        if(currCount >= maxCount) {
            if(currCount > maxCount){
                modeList.clear();
                maxCount = currCount;
            }
            modeList.add(node.val);
        }
        inOrder(node.right);
    }
}