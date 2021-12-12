/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public string serialize(TreeNode root) {
        var sb = new StringBuilder();
        encode(root, sb);
        return sb.ToString();
    }
    
    private void encode(TreeNode node, StringBuilder sb)
    {
        if(node == null)
        {
            sb.Append("#");
            return;
        }
        
        sb.Append(node.val);
        sb.Append(" ");
        encode(node.left, sb);
        sb.Append(" ");
        encode(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data) {
        var queue = new Queue<string>(data.Split(" "));
        return decode(queue);
    }
    
    private TreeNode decode(Queue<string> queue)
    {
        if(queue.Count == 0) return null;
        var v = queue.Dequeue();
        if(v == "#") return null;
        var node = new TreeNode(int.Parse(v));
        node.left = decode(queue);
        node.right = decode(queue);
        
        return node;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));