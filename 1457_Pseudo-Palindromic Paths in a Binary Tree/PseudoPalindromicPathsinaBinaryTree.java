class Solution {
    private int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] list = new int[10];
        pseudoPalindromicPaths(root, list);
        return ans;
    }
    
    private void pseudoPalindromicPaths (TreeNode node, int[] list) {
        if(node == null) return;
        list[node.val]++;
        if(node.left == null && node.right == null) {
            if(isPalindrome(list)) ans++;
        }
        
        pseudoPalindromicPaths(node.left, list);
        pseudoPalindromicPaths(node.right, list);
        list[node.val]--;
    }
    
    private boolean isPalindrome(int[] list) {
        int oddCount = 0;
        for(int v : list) {
            if(v % 2 == 1) oddCount++;
        }
        
        return !(oddCount > 1);
    }
}