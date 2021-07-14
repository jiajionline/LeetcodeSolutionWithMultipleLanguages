public class Solution {
    public int MinSwap(int[] A, int[] B) {
        var keep = Enumerable.Repeat(int.MaxValue, A.Length).ToArray();
        var swap = Enumerable.Repeat(int.MaxValue, A.Length).ToArray();
        keep[0] = 0;
        swap[0] = 1;
        
        for(int i=1;i<A.Length;i++){
            if(A[i] > A[i-1] && B[i] > B[i-1]){
                // Just don't move at all
                keep[i] = keep[i-1];
                // Swapped A[i - 1] / B[i - 1], so that need to swap A[i], B[i] as well
                swap[i] = swap[i-1] + 1;
            }
            
            if(A[i] > B[i-1] && B[i] > A[i-1]){
                // A[i - 1] / B[i - 1] weren't swapped.
                swap[i] = Math.Min(swap[i], keep[i-1] + 1);
                // Swapped A[i - 1] / B[i - 1], no swap needed for A[i] / B[i]
                keep[i] = Math.Min(keep[i], swap[i-1]);
            }
        }
        
        return Math.Min(keep[A.Length-1], swap[A.Length-1]);
    }
}