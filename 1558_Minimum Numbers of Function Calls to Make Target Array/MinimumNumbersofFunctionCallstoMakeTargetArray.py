class Solution:
    def minOperations(self, nums: List[int]) -> int:
        # first part is counting 1s , second part is finding the max highest 1 but need to -3 since in python, 
        # binary starts '0b', also need to minus extra 1.
        return sum(bin(x).count('1') for x in nums) + len(bin(max(nums))) - 3