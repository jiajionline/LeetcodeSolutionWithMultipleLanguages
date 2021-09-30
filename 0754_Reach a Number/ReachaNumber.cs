public class Solution {
    public int ReachNumber(int target) {
        target = Math.Abs(target);
        var k = 0;
        int sum = 0;
        while(sum < target)
        {
            sum += (++k);
        }
        
        var d = sum - target;
        if(d % 2 == 0) return k;
        return k + 1 + (k % 2);
    }
}