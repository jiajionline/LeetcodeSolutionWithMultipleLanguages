class Solution {
    public int numWays(String s) {
        int mod = 1_000_000_007;
        long len = s.length();
        int countOfOne = 0;
        for(char c : s.toCharArray()){
            if(c == '1') countOfOne++;
        }
        if (countOfOne % 3 != 0) return 0;
        if (countOfOne == 0) return (int)(((len - 1) * (len - 2) / 2) % mod);
        countOfOne /= 3;
        long l = 0;
        long r = 0;
        long c = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '1') c += 1;
            if (c == countOfOne)
            {
                l += 1;
            }
            else if (c == countOfOne * 2)
            {
                r += 1;
            }
        }

        return (int)((l * r) % mod);
    }
}