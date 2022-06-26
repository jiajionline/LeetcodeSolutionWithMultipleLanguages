class Solution {
    private static final int mod = 1_000_000_007;
    public int threeSumMulti(int[] arr, int target) {
        long ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int v : arr) count.put(v, count.getOrDefault(v, 0) + 1);
        for(int i : count.keySet())
            for(int j : count.keySet()) {
                int k = target - i - j;
                if(count.containsKey(k)) {
                    long cnt = count.get(i), cnt2 = count.get(j), cnt3 = count.get(k);
                    if(i == j && j == k) {
                        ans += cnt * (cnt -1) * (cnt-2) / 6;  //pick 3 from cnt
                    }else if(i == j) {
                        ans += cnt * (cnt -1) /2 * cnt3; // pick2 from cnt1=2, and cnt3
                    }else if(i < j && j < k) {
                        ans += cnt * cnt2 * cnt3;
                    }
                    ans %= mod; 
                }
            }
        return (int)ans;
    }
}