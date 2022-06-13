public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    private void serialize(TreeNode node, StringBuilder sb) {
        if(node == null) return;
        sb.append(node.val);
        if(node.left != null) {
            sb.append(' ');
            serialize(node.left, sb);
        } 
        if(node.right != null) {
            sb.append(' ');
            serialize(node.right, sb);    
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] s_arr = data.split("\\s");
        int[] arr = new int[s_arr.length];
        for(int i=0;i<s_arr.length;i++) {
            arr[i] = Integer.parseInt(s_arr[i]);
        }
        
        return build(arr, 0, arr.length - 1);
    }
    
    private TreeNode build(int[] arr, int l , int r) {
        if(l > r) return null;
        TreeNode node = new TreeNode(arr[l]);
        int mid = l + 1;
        while(mid <= r) {
            if(arr[mid] > arr[l]) break;
            mid++;
        }
        
        node.left = build(arr, l+1, mid - 1);
        node.right = build(arr, mid , r);
        return node;
    }
}