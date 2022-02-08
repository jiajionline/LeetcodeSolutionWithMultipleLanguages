
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<Node>()));
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);

        while (queue.size() > 0) {
            Node n = queue.poll();

            for (Node childNode : n.neighbors) {
                if (!map.containsKey(childNode)) {
                    map.put(childNode, new Node(childNode.val, new ArrayList<Node>()));
                    queue.offer(childNode);
                }
                map.get(n).neighbors.add(map.get(childNode));
            }
        }

        return map.get(node);
    }
}