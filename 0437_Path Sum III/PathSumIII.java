class Solution {
    private int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        traverse(root, new ArrayList<Integer>(), targetSum);
        return ans;
    }
    
    private void traverse(TreeNode node, List<Integer> list, int targetSum) {
        if(node == null) return;
        list.add(node.val);
        int sum = 0;
        for(int i=list.size()-1;i>=0;i--) {
            sum += list.get(i);
            if(sum == targetSum) ans++;
        }
        
        traverse(node.left, list, targetSum);
        traverse(node.right, list, targetSum);
        list.remove(list.size()-1);
    }
}