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
    public Node CloneGraph(Node node) {
        if(node == null) return null;
        var dict = new Dictionary<Node, Node>();
        dict.Add(node, new Node(node.val));
        var queue = new Queue<Node>();
        queue.Enqueue(node);
        
        while(queue.Count > 0){
            var tmpNode = queue.Dequeue();
            
            foreach(var childNode in tmpNode.neighbors){
                if(!dict.ContainsKey(childNode)){
                dict.Add(childNode, new Node(childNode.val));
                queue.Enqueue(childNode);
            }
            
                dict[tmpNode].neighbors.Add(dict[childNode]);
            }
        }
        
        return dict[node];
        
    }
}