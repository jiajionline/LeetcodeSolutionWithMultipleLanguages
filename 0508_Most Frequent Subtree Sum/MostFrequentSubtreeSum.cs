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
    private int currentMaxFreq = int.MinValue;
    private List<int> list = new List<int>();
    
    public int[] FindFrequentTreeSum(TreeNode root) {
        var frequencyDict = new Dictionary<int,int>();
        Traverse(root, frequencyDict);
        
        return list.ToArray();
    }
    
    private int Traverse(TreeNode node, Dictionary<int,int> frequencyDict)
    {
        if(node == null) return 0;
        var left = Traverse(node.left, frequencyDict);
        var right = Traverse(node.right, frequencyDict);
        
        var v = left + right + node.val;
        
        if(!frequencyDict.ContainsKey(v)) frequencyDict.Add(v,0);
        frequencyDict[v] += 1;
        
        if(frequencyDict[v] >= currentMaxFreq){
            if(frequencyDict[v] > currentMaxFreq)
            {
               list.Clear(); 
            }
            currentMaxFreq = frequencyDict[v];
            list.Add(v);
        }        
        return v;
    }
}