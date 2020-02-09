class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        levelOrder(root,1, ret);
        return ret;
    }
    
    private void levelOrder(Node node,int level, List<List<Integer>> ret)
    {
        if(node == null) return;
        if(ret.size() < level){
            ret.add(new LinkedList<Integer>());
        }
        
        ret.get(level-1).add(node.val);
        if(node.children!=null){
            for(Node n : node.children){
                levelOrder(n, level+1, ret);
            }
        }
    }
}