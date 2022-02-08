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