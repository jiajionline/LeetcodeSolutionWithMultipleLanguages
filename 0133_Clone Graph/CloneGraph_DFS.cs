/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new List<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new List<Node>();
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

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