public class Solution {
    private Dictionary<Node, Node> graph = new Dictionary<Node, Node>();
    
    public Node CloneGraph(Node node) {
        if(node == null) return null;
        if(graph.ContainsKey(node)) return graph[node];
        
        var newNode = new Node(node.val);
        graph.Add(node, newNode);
        
        foreach(var nei in node.neighbors)
        {
            newNode.neighbors.Add(CloneGraph(nei));
        }
        
        return newNode;
    }
    
    
}