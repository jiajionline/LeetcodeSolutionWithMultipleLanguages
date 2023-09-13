class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = s.charAt(0) == '0' ? 0 : 1;
        r[n-1] = s.charAt(n-1) == '1' ? 0 : 1;

        for(int i=1;i<n;i++) {
            l[i] = s.charAt(i) == '1' ? l[i-1] + 1 : l[i-1];
        }

        for(int i=n-2;i>=0;i--) {
            r[i] = s.charAt(i) == '0' ? r[i+1] + 1 : r[i+1];
        }

        // the case all 0s or 1s
        int ans = Math.min(r[0], l[n-1]);
        for(int i=1;i<n;i++) {
            ans = Math.min(ans, l[i-1] + r[i]);
        }
        return ans;
    }
}