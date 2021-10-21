public class Solution {
    public int MaxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        
        var ans = 0;
        var len = status.Length;
        var hasBoxes = new bool[len];
        var hasKeys = new bool[len];
        for(int i=0;i<len;i++)
        {
            if(status[i] == 1) hasKeys[i] = true;
        }
        
        var queue = new Queue<int>();
        
        foreach(var box in initialBoxes)
        {
            hasBoxes[box] = true;
            if(hasKeys[box]) queue.Enqueue(box);
        }
        
        while(queue.Count > 0)
        {
            var box = queue.Dequeue();
            ans += candies[box];
            
            foreach(var subBox in containedBoxes[box])
            {
                hasBoxes[subBox] = true;
                if(hasKeys[subBox]) queue.Enqueue(subBox);
            }
            
            foreach(var key in keys[box])
            {
                if(!hasKeys[key] && hasBoxes[key]) queue.Enqueue(key);
                hasKeys[key] = true;
            }
        }
        
        return ans;
    }
}