class Solution {
    private int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        traverse(root, new ArrayList<Long>(), targetSum);
        return ans;
    }
    
    private void traverse(TreeNode node, List<Long> list, int targetSum) {
        if(node == null) return;
        list.add((long)node.val);
        long sum = 0;
        for(int i=list.size()-1;i>=0;i--) {
            sum += list.get(i);
            if(sum == targetSum) ans++;
        }
        
        traverse(node.left, list, targetSum);
        traverse(node.right, list, targetSum);
        list.remove(list.size()-1);
    }
}