class Solution {
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> modeList = new ArrayList<>();
        int maxCount = 0;
        int currMode = Integer.MIN_VALUE;
        int currCount = 0;
        
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(root.val != currMode) {
                currMode = root.val;
                currCount = 0;
            }
            
            currCount++;
            if(currCount > maxCount) {
                modeList.clear();
                modeList.add(currMode);
                maxCount = currCount;
            }else if(currCount == maxCount) {
                modeList.add(currMode);
            }
            
            root = root.right;
        }
        
        int[] ans = new int[modeList.size()];
        for(int i=0;i<ans.length;i++) ans[i] = modeList.get(i);
        
        return ans;
    }
}