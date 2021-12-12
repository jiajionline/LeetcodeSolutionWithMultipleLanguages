import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Base64;

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
    
    private static final byte NULL = 0;
    private static final byte ROOT = 1;
    private static final byte LEFT = 2;
    private static final byte RIGHT = 4;

  
    public String serialize(TreeNode root) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             DataOutputStream os = new DataOutputStream(baos)) {
            write(root, os);
            byte[] encodedBytes = Base64.getEncoder().encode(baos.toByteArray());
            return new String(encodedBytes);
        }catch (Exception e){
            return null;
        }
    }

    public TreeNode deserialize(String data) {
        if (data == null) return null;
        byte[] b = Base64.getDecoder().decode(data);
        try (ByteArrayInputStream is = new ByteArrayInputStream(b);
             DataInputStream dis = new DataInputStream(is)) {
            return read(dis);
        } catch (Exception e) {
            return null;
        }
    }

    //status(1byte) + content(4byte)
    private void write(TreeNode root, DataOutputStream os) throws IOException {
        int status = NULL;
        if (root != null) status |= ROOT;
        if (root != null && root.left != null) status |= LEFT;
        if (root != null && root.right != null) status |= RIGHT;
        os.writeByte(status);
        if (root == null) return;
        
        os.writeInt(root.val);
        if (root.left != null) write(root.left, os);
        if (root.right != null) write(root.right, os);
    }

    private TreeNode read(DataInputStream is) throws IOException {
        byte status = is.readByte();
        if ((status & ROOT) == 0) return null;

        TreeNode root = new TreeNode(is.readInt());
        root.left = (status & LEFT) != 0 ? read(is) : null;
        root.right = (status & RIGHT) != 0 ? read(is) : null;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));