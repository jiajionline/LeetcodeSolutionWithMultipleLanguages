class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            ans.add(node.val);
            if(node.children!=null) {
                for(Node child : node.children){
                    stack.push(child);
                }
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}