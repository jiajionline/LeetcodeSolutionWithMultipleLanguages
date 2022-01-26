class Solution {
    public boolean isPalindrome(int x) {
        long n = x;
        long m = n;
        long k = 0;
        
        while(m > 0)
        {
            k *= 10;
            k += (m % 10);
            m /= 10;
        }
        
        return k == n;
    }
}