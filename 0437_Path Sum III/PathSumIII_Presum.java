class Solution {
    private int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        pathSum(root, targetSum, 0, new HashMap<Integer,Integer>());
        return ans;
    }
    
    private void pathSum(TreeNode node, int targetSum, int currSum, Map<Integer,Integer> map) {
        if(node == null) return;
        
        currSum += node.val;
        if(currSum == targetSum) ans++;
        
        ans += map.getOrDefault(currSum - targetSum, 0);
        
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        
        pathSum(node.left, targetSum, currSum, map);
        pathSum(node.right, targetSum, currSum, map);
        
        map.put(currSum, map.get(currSum) - 1);
    }
}