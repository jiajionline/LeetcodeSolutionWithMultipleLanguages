class Solution {
    private int mostLeftVertical = Integer.MAX_VALUE;
    private int mostRightVertical = Integer.MIN_VALUE;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
        return ans;
        }

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int column = 0;
        queue.offer(new Pair(root, column));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            column = p.getValue();
            mostLeftVertical = Math.min(mostLeftVertical, column);
            mostRightVertical = Math.max(mostRightVertical, column);
            
            if (node != null) {
                if (!map.containsKey(column)) {
                map.put(column, new ArrayList<Integer>());
                }
                map.get(column).add(node.val);

                queue.offer(new Pair(node.left, column - 1));
                queue.offer(new Pair(node.right, column + 1));
            }
        }

        for(int i=mostLeftVertical;i<= mostRightVertical;i++) {
            if(map.containsKey(i)) {
                ans.add(map.get(i));
            }
        }

        return ans;
    }
}