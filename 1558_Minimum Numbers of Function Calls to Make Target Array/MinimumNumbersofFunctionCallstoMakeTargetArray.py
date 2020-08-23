class Solution:
    def minOperations(self, nums: List[int]) -> int:
        return sum(bin(x).count('1') for x in nums) + len(bin(max(nums))) - 3