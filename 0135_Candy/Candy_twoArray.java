class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] leftDP = new int[n];
        int[] rightDP = new int[n];
        Arrays.fill(leftDP, 1);
        Arrays.fill(rightDP, 1);

        for(int i=1;i<n;i++) {
            if(ratings[i] > ratings[i-1])
                leftDP[i] = leftDP[i-1] + 1; 
        }

        for(int i=n-2;i>=0;i--) {
            if(ratings[i] > ratings[i+1])
                rightDP[i] = rightDP[i+1] + 1;
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            ans += Math.max(leftDP[i], rightDP[i]);
        }

        return ans;
    }
}