class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node n = stack.pop();
            if(n.children != null){
                for(Node node: n.children){
                    stack.push(node);
                }
            }
            list.addFirst(n.val);
        }
        
        return list;
    }
}