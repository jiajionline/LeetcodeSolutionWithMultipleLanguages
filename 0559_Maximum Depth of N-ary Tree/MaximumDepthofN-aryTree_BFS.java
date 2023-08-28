class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while(q.size() > 0) {
            ans++;
            int size = q.size();
            while(size-- > 0) {
                Node node = q.poll();
                if(node.children != null) {
                    for(Node child : node.children){
                        q.offer(child);
                    }
                }
            }
        }
        return ans;
    }
}