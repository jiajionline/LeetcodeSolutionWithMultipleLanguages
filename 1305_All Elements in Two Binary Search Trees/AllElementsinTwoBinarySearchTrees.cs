/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public IList<int> GetAllElements(TreeNode root1, TreeNode root2) {
        var ans = new List<int>();
        if(root1 == null && root2 == null) return ans;
        
        var list1 = new List<int>();
        var list2 = new List<int>();
        InOrder(root1, list1);
        InOrder(root2, list2);
        
        int i = 0;
        int j = 0;
        while(i < list1.Count && j < list2.Count){
            if(list1[i] == list2[j]){
                ans.Add(list1[i++]);
                ans.Add(list2[j++]);
            }else if(list1[i] < list2[j]){
                ans.Add(list1[i++]);
                
            }else{
                ans.Add(list2[j++]);
                
            }
        }
        
        while(i < list1.Count) ans.Add(list1[i++]);
        while(j < list2.Count) ans.Add(list2[j++]);
        
        return ans;
    }
    
    private void InOrder(TreeNode node, IList<int> list){
        if(node == null) return;
        InOrder(node.left, list);
        list.Add(node.val);
        InOrder(node.right, list);
    }
}