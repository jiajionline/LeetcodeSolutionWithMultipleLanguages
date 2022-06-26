class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int modulo = (int)Math.pow(10,9) + 7;
        int ans = 0;
        for(int i=0;i<arr.length;i++) {
            ans = (ans + map.getOrDefault(target - arr[i], 0)) % modulo;
            for(int j=0;j<i;j++) {
                int tmp = arr[i] + arr[j];
                map.put(tmp, map.getOrDefault(tmp,0) + 1);
            }
        }
        return ans;
    }
}