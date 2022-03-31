public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n+1];
        ugly[1] = 1;
        int index2 = 1, index3 = 1, index5 = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=2;i<=n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n];
    }
}