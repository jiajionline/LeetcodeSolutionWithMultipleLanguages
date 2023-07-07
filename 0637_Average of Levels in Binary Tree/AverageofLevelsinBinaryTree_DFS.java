class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<double[]> list = new ArrayList<>();
        averageOfLevels(root, 0, list);
        List<Double> ans = new ArrayList<>();
        for(double[] arr : list) {
            ans.add(arr[1]/arr[0]);
        }

        return ans;
    }

    private void averageOfLevels(TreeNode node, int depth, List<double[]> list) {
        if(node == null) return;
        if(list.size() == depth){
            double[] arr = new double[2];
            list.add(arr);
        }
        list.get(depth)[0]++;
        list.get(depth)[1] += node.val;
        averageOfLevels(node.left, depth+1, list);
        averageOfLevels(node.right, depth+1, list);
    }
}