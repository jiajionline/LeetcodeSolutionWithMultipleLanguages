public class Solution {
    public TreeNode BstToGst(TreeNode root) {
        var list = new List<int>();
        InOrder(root, list);
        
        var dict = new Dictionary<int,int>();
        var sum = 0;
        
        for(var i = list.Count-1;i>=0;i--)
        {
            var v = list[i];
            sum += v;
            dict.Add(v, sum);
        }
        
        Build(root, dict);
        return root;
        
    }
    
    private void Build(TreeNode node, Dictionary<int,int> dict)
    {
        if(node == null) return;
        node.val = dict[node.val];
        Build(node.left, dict);
        Build(node.right, dict);
    }
    
    private void InOrder(TreeNode node, List<int> list)
    {
        if(node == null) return;
        InOrder(node.left, list);
        list.Add(node.val);
        InOrder(node.right, list);
    }
}