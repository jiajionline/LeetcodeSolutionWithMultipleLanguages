class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int pDepth = depth(p);
        int qDepth = depth(q);
        
        if(pDepth > qDepth) {
            for(int i=0;i<pDepth - qDepth;i++)
                p = p.parent;
        }else if(pDepth < qDepth) {
            for(int i=0;i<qDepth - pDepth;i++)
                q = q.parent;
        }
        
        return lowest(p, q);
    }
    
    private Node lowest(Node p, Node q) {
        if(p == q) return p;
        return lowest(p.parent, q.parent);
    }
    
    private int depth(Node p) {
        if(p == null) return 0;
        if(p.parent == null) return 1;
        return depth(p.parent) + 1;
    }
}