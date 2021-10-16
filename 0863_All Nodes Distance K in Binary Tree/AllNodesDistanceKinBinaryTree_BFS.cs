/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<int> DistanceK(TreeNode root, TreeNode target, int k) {
        var graph = new Dictionary<int, List<int>>();
        BuildGraph(graph, root, null);
        
        var ans = new List<int>();
        var visited = new HashSet<int>();
        visited.Add(target.val);
        var queue = new Queue<int>();
        queue.Enqueue(target.val);
        var currK = 0;
        
        while(queue.Count > 0 && currK <= k)
        {
            var s = queue.Count;
            while(s-- > 0)
            {
                var n = queue.Dequeue();
                
                if(currK == k) ans.Add(n);
               
                if(graph.ContainsKey(n))
                {
                    foreach(var nei in graph[n])
                    {
                        if(visited.Contains(nei)) continue;
                        queue.Enqueue(nei);
                        visited.Add(nei);
                    }    
                }
                
            }
            
            currK++;
        }
        
        return ans;
    }
    
    private void DFS(Dictionary<int, List<int>> graph, int v, int k, HashSet<int> visited, List<int> ans)
    {
        
    }
    
    private void BuildGraph(Dictionary<int, List<int>> graph, TreeNode node, TreeNode parent)
    {
        if(node == null) return;
        if(parent!=null){
            if(!graph.ContainsKey(parent.val)) graph.Add(parent.val, new List<int>());
            if(!graph.ContainsKey(node.val)) graph.Add(node.val, new List<int>());
            
            graph[parent.val].Add(node.val);
            graph[node.val].Add(parent.val);
        }
        
        BuildGraph(graph, node.left, node);
        BuildGraph(graph, node.right, node);
    }
}