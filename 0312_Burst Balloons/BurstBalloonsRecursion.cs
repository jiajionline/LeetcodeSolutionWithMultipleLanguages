public class Solution {
    private int[] vals;
    private int[,] mem;
    public int MaxCoins(int[] nums) {
        
        mem = new int[nums.Length+2, nums.Length+2];
        vals = new int[nums.Length+2];
        vals[0] = 1;
        vals[vals.Length -1] = 1;
        
        for(int i=0;i<nums.Length;i++)
        {
            vals[i+1] = nums[i];
        }
        
        return MaxCoins(1,nums.Length);
        
    }
    
    private int MaxCoins(int i, int j)
    {
        if(i > j) return 0;
        if(i == j) return vals[i-1] * vals[i] * vals[i+1];
        if(mem[i,j] > 0) return mem[i,j];
        
        var most = 0;
        for(int k = i;k<=j;k++)
        {
            most = Math.Max(most, MaxCoins(i,k-1) + vals[i-1] * vals[k] * vals[j+1] + MaxCoins(k+1,j));
        }
        
        mem[i,j] = most;
        
        return most;
    }
}