public class Solution {
    public int CanCompleteCircuit(int[] gas, int[] cost) {
        var start = 0;
        var totalLeft = 0;
        var currLeft = 0;
        
        for(int i=0;i<gas.Length;i++)
        {
            currLeft += gas[i] - cost[i];
            if(currLeft < 0)
            {
                start = i+1;
                currLeft = 0;
            }
            
            totalLeft += gas[i] - cost[i];
        }
        
        return totalLeft < 0 ? -1 : start;
    }
}