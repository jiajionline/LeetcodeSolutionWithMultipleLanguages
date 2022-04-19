class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        DFS(node, map);
        return map.get(node);
    }
    
    private void DFS(Node node, Map<Node, Node> map) {
        if(node == null || map.containsKey(node)) return;
        Node copy = new Node(node.val);
        map.put(node, copy);
        for(Node next : node.neighbors) {
            DFS(next, map);
            copy.neighbors.add(map.get(next));
        }
    }
}