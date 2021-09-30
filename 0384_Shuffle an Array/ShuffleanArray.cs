public class Solution {

    private int[] original;
    private int[] shuffled;
    public Solution(int[] nums) {
        original = new int[nums.Length];
        shuffled = new int[nums.Length];
        
        Array.Copy(nums, original, nums.Length);
        Array.Copy(nums, shuffled, nums.Length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] Reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] Shuffle() {
        var random = new Random();
        for(int i=shuffled.Length-1;i>=0;i--)
        {
            var index = random.Next(i+1);
            var tmp = shuffled[i];
            shuffled[i] = shuffled[index];
            shuffled[index] = tmp;
        }
        
        return shuffled;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.Reset();
 * int[] param_2 = obj.Shuffle();
 */