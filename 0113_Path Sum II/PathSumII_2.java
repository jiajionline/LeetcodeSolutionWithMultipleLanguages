class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        traverse(root, targetSum, new ArrayList<Integer>(), 0, ans);
        return ans;
    }

    private void traverse(TreeNode node, int targetSum, List<Integer> list, int sum, List<List<Integer>> ans) {
        if(node == null) {
            return;
        }
        list.add(node.val);
        sum += node.val;
        if(node.left == null && node.right == null) {
            if(sum == targetSum) {
                ans.add(new ArrayList<Integer>(list));
            }
        }
        traverse(node.left, targetSum, list, sum, ans);
        traverse(node.right, targetSum, list, sum, ans);
        list.remove(list.size() - 1);
    }
}