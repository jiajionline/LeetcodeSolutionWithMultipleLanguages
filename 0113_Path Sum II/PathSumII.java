class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        pathSum(root, targetSum, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void pathSum(TreeNode node , int targetSum , List<Integer> list, List<List<Integer>> ans) {
        if(node == null) return;
        list.add(node.val);
        
        if(node.left == null && node.right == null && targetSum == node.val) {
            ans.add(new ArrayList<Integer>(list));
        }else{
            pathSum(node.left, targetSum - node.val, list, ans);
            pathSum(node.right, targetSum - node.val , list, ans);  
        }
        list.remove(list.size()-1);  
    }
}