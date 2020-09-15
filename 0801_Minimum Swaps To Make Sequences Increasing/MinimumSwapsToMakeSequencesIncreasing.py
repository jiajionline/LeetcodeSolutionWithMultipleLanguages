class Solution(object):
    def minSwap(self, A, B):
        keep1, swap1 = 0, 1
        for i in range(1, len(A)):
            keep2 = swap2 = float("inf")
            if A[i-1] < A[i] and B[i-1] < B[i]:
                keep2 = min(keep2, keep1)
                swap2 = min(swap2, swap1 + 1)
            if A[i-1] < B[i] and B[i-1] < A[i]:
                keep2 = min(keep2, swap1)
                swap2 = min(swap2, keep1 + 1)

            keep1, swap1 = keep2, swap2

        return min(keep1, swap1)
