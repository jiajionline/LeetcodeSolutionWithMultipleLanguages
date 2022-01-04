public class Solution {
    public IList<int> Preorder(Node root) {
        var ret = new List<int>();
        Preorder(root,ret);
        return ret;
    }
    
    private void Preorder(Node node, IList<int> ret)
    {
        if(node==null) return;
        ret.Add(node.val);
        if(node.children == null) return;
        foreach(var n in node.children)
        {
            Preorder(n, ret);
        }
    }
}