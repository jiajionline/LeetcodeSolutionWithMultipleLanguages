public class Solution {
   public int MinDepth(TreeNode root) {
       if(root == null) return 0;
       var queue = new Queue <TreeNode> ();
       int currentLevel = 1;
       queue.Enqueue(root);
      
       while (queue.Count > 0) {
           int currentLevelSize = queue.Count;
           while (currentLevelSize > 0) {
               var node = queue.Dequeue();
               if (node.left == null && node.right == null) {
                   return currentLevel;
               }

               if (node.left != null) {
                   queue.Enqueue(node.left);
               }

               if (node.right != null) {
                   queue.Enqueue(node.right);
               }

               currentLevelSize--;
           }          
           currentLevel++;
       }
      
       return currentLevel;
   }
}