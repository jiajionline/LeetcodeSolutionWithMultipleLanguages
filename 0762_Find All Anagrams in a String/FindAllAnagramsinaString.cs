public class Solution {
    public int CountPrimeSetBits(int left, int right) {
        bool[] isPrime = new bool[33];
        Array.Fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i=2;i<33;i++)
        {
            if(!isPrime[i]) continue;
            for(int j=i*2;j<33;j+=i)
            {
                isPrime[j] = false;
            }
        }
        
        var ans = 0;
        for(int i=left;i<=right;i++)
        {
            if(isPrime[CountOf1(i)]) ans++;
        }
        
        return ans;
    }
    
    private int CountOf1(int v)
    {
        var ret = 0;
        while(v > 0)
        {
            if((v & 1) > 0) ret++;
            v >>= 1;
        }
        
        return ret;
    }
    
    
}