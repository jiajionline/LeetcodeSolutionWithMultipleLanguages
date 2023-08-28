class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        if(root.children == null) return 1;
        int max = 0;
        if(root.children !=null) {
            for(Node child : root.children){
                max = Math.max(max, maxDepth(child));
            }
        }
        return max+1;
    }
}