public class Solution {
    public int MinEatingSpeed(int[] piles, int h) {
        var l = 1;
        var r = piles.Max() + 1;
        
        while(l < r)
        {
            var m = (r-l)/2 + l;
            var h2 = 0;
            foreach(var p in piles)
            {
                h2 += p/m;
                if(p % m !=0)
                    h2 += 1;
            }
            
            if(h2 <= h){
                r = m;
            }else{
                l = m + 1;
            }
        }
        
        return l;
    }
}