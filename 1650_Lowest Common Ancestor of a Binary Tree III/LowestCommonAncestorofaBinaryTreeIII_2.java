class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node node1 = p, node2 = q;
        while(node1 != node2) {
            node1 = node1 == null ? q : node1.parent;
            node2 = node2 == null ? p : node2.parent;
        }
        
        return node1;
        
    }
}