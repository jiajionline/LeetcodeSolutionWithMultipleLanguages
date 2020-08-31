class Solution:
    def numOfWays(self, nums: List[int]) -> int:
        def ways(nums: List[int]) -> int:
            if len(nums) <= 2: return 1
            left = [x for x in nums if x < nums[0]]
            right =[x for x in nums if x > nums[0]]
            return (math.comb(len(left) + len(right), len(left)) * ways(left) * ways(right))
        # Minus 1 from the result because we don't count the original ordering.
        return (ways(nums)-1) % (10**9 + 7)