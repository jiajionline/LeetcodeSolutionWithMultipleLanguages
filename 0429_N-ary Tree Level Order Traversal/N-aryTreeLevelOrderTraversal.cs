/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, IList<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

public class Solution {
    public IList<IList<int>> LevelOrder(Node root) {
        var ans = new List<IList<int>>();
        if(root == null) return ans;
        var q = new Queue<Node>();
        q.Enqueue(root);
        
        while(q.Count > 0){
            var c = q.Count;
            var list = new List<int>();
            for(int i=0;i<c;i++){
                var n = q.Dequeue();
                list.Add(n.val);
                if(n.children!=null){
                    foreach(var childNode in n.children){
                        q.Enqueue(childNode);
                    }
                }
            }
            
            ans.Add(list);
        }
        
        return ans;
    }
}