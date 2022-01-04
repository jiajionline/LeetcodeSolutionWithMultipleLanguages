public class Solution {
    public IList<int> Preorder(Node root) {
        var ans = new List<int>();
        if(root == null) return ans;
        var stack = new Stack<Node>();
        stack.Push(root);
        
        while(stack.Count > 0)
        {
            var node = stack.Pop();
            ans.Add(node.val);
            if(node.children!=null)
            {
                for(int i=node.children.Count -1 ; i>=0;i--)
                    stack.Push(node.children[i]);    
            }
        }
        
        return ans;
    }
}