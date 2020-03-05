/**
* Definition for a binary tree node.
* public class TreeNode {
*     public int val;
*     public TreeNode left;
*     public TreeNode right;
*     public TreeNode(int x) { val = x; }
* }
*/
public class Solution {
   public IList<IList<int>> PathSum(TreeNode root, int sum) {
       var ans = new List<IList<int>>();
        if(root == null) return ans;
        PathSum(root, sum, new List<int>(), ans);
        return ans;
   }

    private void PathSum(TreeNode node, int sum, IList<int> list, IList<IList<int>> ans)
    {
        if(node == null) return;
        if(node.left == null && node.right == null && node.val == sum)
        {
            var tmpList = new List<int>(list);
            tmpList.Add(node.val);
            ans.Add(tmpList);
            return;         
        }

        list.Add(node.val);     
        PathSum(node.left, sum - node.val, list, ans);      
        PathSum(node.right, sum - node.val, list, ans);
        

        list.RemoveAt(list.Count()-1);
    }
}
