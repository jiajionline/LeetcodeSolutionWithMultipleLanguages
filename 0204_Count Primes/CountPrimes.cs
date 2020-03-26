public class Solution {
    public int CountPrimes(int n) {
        if(n <=0) return 0;
        int ans = 0;
        var isPrime = new bool[n+1];
        Array.Fill(isPrime,true);
        isPrime[0] = false;
        if(n>0) isPrime[1] = false;

        for(int i=2;i<n;i++){
            if(!isPrime[i]) continue;
            ans++;
            for(int j=i * 2;j<=n;j+=i){
                isPrime[j] = false;
            }
        }

        return ans;
    }
}