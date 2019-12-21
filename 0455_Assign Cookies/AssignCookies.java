import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0 || s == null || s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int childIndex =0, cookieIndex = 0;
        while(childIndex<g.length && cookieIndex < s.length){
            if(g[childIndex] <= s[cookieIndex]){
                ans++;
                childIndex++;
                cookieIndex++;
            }else{
                cookieIndex++;
            }
        }

        return ans;
    }
}