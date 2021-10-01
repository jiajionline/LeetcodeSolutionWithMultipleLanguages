public class Solution {
    public bool IsHappy(int n) {
        if(n <= 0) return false;
        if(n == 1) return true;
        var set = new HashSet<int>();
        
        while(!set.Contains(n))
        {
            set.Add(n);
            var sum = 0;
            while(n > 0)
            {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            
            if(sum == 1) return true;
            n = sum;
        }
        
        return false;
    }
}