class Solution {
    private Map<Integer,Node> levelToNodeMap = new HashMap<>();
    public Node connect(Node root) {
        traverse(root, 1);
        return root;
    }

    private void traverse(Node node, int level) {
        if(node == null) return;
        if(levelToNodeMap.containsKey(level)) {
            Node leftNode = levelToNodeMap.get(level);
            leftNode.next = node;
            levelToNodeMap.put(level, node);
        }
        levelToNodeMap.put(level, node);
        traverse(node.left, level+1);
        traverse(node.right, level+1);
    }
}