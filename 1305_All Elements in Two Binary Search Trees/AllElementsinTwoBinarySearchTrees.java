/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traverse(root1, list1);
        traverse(root2, list2);

        List<Integer> ans = new ArrayList<>();
        int index1 = 0, index2 = 0;
        while(index1 < list1.size() || index2 < list2.size()) {
            if(index1 < list1.size() && index2 < list2.size()) {
                if(list1.get(index1) <= list2.get(index2)){
                    ans.add(list1.get(index1++));
                }else{
                    ans.add(list2.get(index2++));
                }
            }else if(index1 < list1.size()){
                ans.add(list1.get(index1++));
            }else{
                 ans.add(list2.get(index2++));
            }
        }

        return ans;
    }

    private void traverse(TreeNode node, List<Integer> list) {
        if(node == null) return;
        traverse(node.left, list);
        list.add(node.val);
        traverse(node.right, list);
    }
}