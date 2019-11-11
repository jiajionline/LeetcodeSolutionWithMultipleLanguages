from collections import Counter
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if not nums or len(nums) == 0:return 0
        counter = Counter()
        counter[0] = 1
        ans = sum = 0
        for v in nums:
            sum += v
            ans += counter[sum-k]
            counter[sum] +=1
        return ans
