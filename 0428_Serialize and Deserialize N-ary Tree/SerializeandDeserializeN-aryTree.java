class Codec {
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> list = new ArrayList<>();
        serialize(root, list);
        return String.join(" ", list);
    }
    
    private void serialize(Node node, List<String> list) {
        if(node == null) return;
        list.add(String.valueOf(node.val));
        list.add(String.valueOf(node.children.size()));
        for(Node next : node.children) {
            serialize(next, list);
        }
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split("\\s")));
        return deserialize(q);
    }
    
    private Node deserialize(Queue<String> q) {
        if(q.size() == 0) return null;
        Node node = new Node(Integer.parseInt(q.poll()), new ArrayList<Node>());
        int size = Integer.parseInt(q.poll());
        for(int i=0;i<size;i++) {
            node.children.add(deserialize(q));
        }
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));