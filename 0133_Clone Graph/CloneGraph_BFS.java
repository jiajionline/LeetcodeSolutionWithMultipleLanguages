class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node, new Node(node.val));
        
        while(queue.size() > 0) {
            Node n = queue.poll();
            Node copy = map.get(n);
            for(Node next : n.neighbors) {
                if(!map.containsKey(next)) {
                    map.put(next, new Node(next.val));
                    queue.offer(next);
                }
                
                 copy.neighbors.add(map.get(next));
            }
        }
        
        return map.get(node);
    }
}