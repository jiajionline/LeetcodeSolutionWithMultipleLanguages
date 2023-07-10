class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean isReversed = false;
        while(q.size() > 0) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            ans.add(list);
            while(size-->0) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        
        for(int i=1;i<ans.size();i+=2) {
            Collections.reverse(ans.get(i));
        }

        return ans;
    }
}