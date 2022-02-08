class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node,Node> map = new HashMap();
        visit(map, node);
        return map.get(node);
    }
    
    private void visit(HashMap<Node, Node> map, Node node) {
        if(!map.containsKey(node)) {
            Node clone = new Node(node.val);
            map.put(node, clone);
            for(Node neighbor : node.neighbors) {
                visit(map, neighbor);
                clone.neighbors.add(map.get(neighbor));
            }
        }
    }
}