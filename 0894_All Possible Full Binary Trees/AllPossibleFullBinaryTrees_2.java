class Solution {
    private Map<Integer, List<TreeNode>> map = new HashMap();
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new ArrayList();
        if(n % 2 == 0) return list;
        if(n == 1)  {
            list.add(new TreeNode(0));
            return list;
        }
        
        if(map.containsKey(n)) return map.get(n);
        
        for(int i=1;i<n;i+=2) {
            for(TreeNode left : allPossibleFBT(i)) {
                for(TreeNode right : allPossibleFBT(n-i-1)) {
                    TreeNode node = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
        
        map.put(n, list);
        
        return list;
    }
}