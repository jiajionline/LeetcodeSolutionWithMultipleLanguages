class Solution:
    def minDeletions(self, s: str) -> int:
        count, ans, used = collections.Counter(s), 0, set()
        for c, freq in count.items():
            while freq > 0 and freq in used:
                freq -= 1
                ans += 1
            used.add(freq)
        return ans