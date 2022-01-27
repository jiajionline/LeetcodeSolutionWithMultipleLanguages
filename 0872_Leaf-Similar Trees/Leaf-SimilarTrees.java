class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        traverse(root1, list1);
        traverse(root2, list2);
        
        if(list1.size() != list2.size()) return false;
        for(int i=0;i<list1.size();i++)
            if(list1.get(i) != list2.get(i)) return false;
        
        return true;
    }
    
    private void traverse(TreeNode node, List<Integer> list) {
        if(node == null) return;
        if(node.left == null && node.right == null) list.add(node.val);
        traverse(node.left, list);
        traverse(node.right, list);
    }
}