class Codec {
    public String serialize(Node root) {
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }
    private void serialize(Node node, StringBuilder sb){
        if(node==null){
            sb.append('#');
            return;
        }
        
        sb.append(node.val);
        sb.append(' ');
        sb.append(node.children.size());
        sb.append(' ');
        for (Node child:node.children){
            serialize(child,sb);
        }
        
    }

    public Node deserialize(String data) {
        Queue<String> q=new LinkedList<>(Arrays.asList(data.split("\\s")));
        return deserialize(q);
    }
    private Node deserialize(Queue<String> q){
        if(q.size() == 0) return null;
        String s1=q.poll();
        if(s1.equals("#")) return null;
        
        int v=Integer.valueOf(s1);
        int size=Integer.valueOf(q.poll());
        
        Node root=new Node(v, new ArrayList<Node>());
        for (int i=0;i<size;i++){
            root.children.add(deserialize(q));
        }
        return root;
    }
}