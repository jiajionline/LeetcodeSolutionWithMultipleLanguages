class Solution {
    public int maxLevelSum(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        traverse(root, 0, levelSum);
        int level = -1;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<levelSum.size();i++) {
            if(maxSum < levelSum.get(i)) {
                level = i+1;
                maxSum = levelSum.get(i);
            }
        }
        return level;
    }

    private void traverse(TreeNode node, int level,List<Integer> levelSum) {
        if(node == null) return;
        if(levelSum.size() == level) {
            levelSum.add(0);
        }
        levelSum.set(level, levelSum.get(level) + node.val);
        traverse(node.left, level+1, levelSum);
        traverse(node.right, level+1, levelSum);
    }
}