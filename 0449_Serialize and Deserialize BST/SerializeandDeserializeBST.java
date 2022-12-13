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
        if(node == null) return;
        sb.append(node.val);
        if(node.left!=null){
            sb.append(",");
            serialize(node.left, sb);
        }
        if(node.right!=null){
            sb.append(",");
            serialize(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserialize(Queue<String> q, int lower, int higher){
        if(q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.parseInt(s);
        if(val < lower || val > higher) return null;
        q.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserialize(q, lower, val);
        node.right = deserialize(q, val, higher);
        return node;
    }
}