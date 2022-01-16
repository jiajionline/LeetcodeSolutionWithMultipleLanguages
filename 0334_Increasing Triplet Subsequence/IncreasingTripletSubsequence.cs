public class Solution {
    public bool IncreasingTriplet(int[] nums) {
        if(nums.Length <=2 ) return false;
        var min = int.MaxValue;
        var max = int.MaxValue;
        
        foreach(var v in nums)
        {
            if(v > max) return true;
            else if(v < min)
                min = v;
            else if(v > min && v < max)
                max = v;
        }
        
        return false;
    }
}