class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        return traverse(root, arr);
    }

    private int traverse(TreeNode node, int[] counter) {
        if(node == null) return 0;
        int v = 0;
        counter[node.val]++;
        if(node.left == null && node.right == null) {
            if(isPalindromic(counter)) v++;
        }
        v += traverse(node.left, counter);
        v += traverse(node.right, counter);
        counter[node.val]--;
        return v;
    }

    private boolean isPalindromic(int[] arr) {
        int cntOfOdd = 0;
        for(int v : arr){
            if(v % 2 == 1) cntOfOdd++;
        }
        return cntOfOdd <= 1;
    }
}