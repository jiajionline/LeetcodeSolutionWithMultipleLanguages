public class Solution {
    public int LongestMountain(int[] A) {
        var len = A.Length;
        var increase = new int[len];
        var decrease = new int[len];

        for(int i=1;i<len;i++){
            if(A[i] > A[i-1])
                increase[i] = increase[i-1] + 1;
        }

        for(int i=len-2;i>=0;i--){
            if(A[i] > A[i+1])
                decrease[i] = decrease[i+1] + 1;
        }

        var ans = 0;
        for(int i=0;i<len;i++){
            if(increase[i] > 0 && decrease[i] > 0)
                ans = Math.Max(ans, increase[i] + decrease[i] + 1);
        }

        return ans >=3 ? ans : 0;
    }
}