class Solution {
    public int minSwap(int[] A, int[] B) {
        // n: natural, s: swapped
        int keep1 = 0, swap1 = 1;
        for (int i = 1; i < A.length; ++i) {
            int keep2 = Integer.MAX_VALUE, swap2 = Integer.MAX_VALUE;
            if (A[i-1] < A[i] && B[i-1] < B[i]) {
                keep2 = Math.min(keep2, keep1);
                swap2 = Math.min(swap2, swap1 + 1);
            }
            if (A[i-1] < B[i] && B[i-1] < A[i]) {
                keep2 = Math.min(keep2, swap1);
                swap2 = Math.min(swap2, keep1 + 1);
            }
            keep1 = keep2;
            swap1 = swap2;
        }
        return Math.min(keep1, swap1);
    }
}