public class Solution {
       
    public int NumTrees(int n) {
        var memo = new int[n+1];
        return NumTrees(n, memo);
    }
    
    private int NumTrees(int n, int[] memo)
    {
        if(n <= 1) return 1;
        if(memo[n] > 0) return memo[n];
        
        var sum = 0;
        // the node as a root is from to n inclusively
        for(int root=1;root<=n;root++)
        {
            //calculate the left nodes of root 
            var left = NumTrees(root-1, memo);
            //calculate the right nodes of root
            //make sure the total left + right should be equal to n - 1 (root - 1 + n - root == n-1)
            var right = NumTrees(n - root, memo);
            sum += left * right;
            
        }
        
        memo[n] = sum;
        return sum;
    }
}