/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("#");
            return;
        }
        
        sb.append(node.val);
        sb.append(" ");
        serialize(node.left, sb);
        sb.append(" ");
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>(Arrays.asList(data.split("\\s")));
        return deserialize(queue);
    }
    
    private TreeNode deserialize(Queue<String> queue) {
        if(queue.size() == 0) return null;
        String v = queue.poll();
        if(v.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(v));
        node.left = deserialize(queue);
        node.right = deserialize(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));