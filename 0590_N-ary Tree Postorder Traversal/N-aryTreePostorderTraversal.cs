public class Solution {
    public IList<int> Postorder(Node root) {
        var ret = new List<int>();
        Postorder(root, ret);
        return ret;
    }
    
    private void Postorder(Node node, IList<int> list)
    {
        if(node == null) return;
        if(node.children!=null){
            foreach(var n in node.children){
                Postorder(n,list);
            }
        }
        
        list.Add(node.val);
        
    }
}