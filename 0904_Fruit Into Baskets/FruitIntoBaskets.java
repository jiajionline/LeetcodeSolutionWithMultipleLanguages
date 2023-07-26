class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer,Integer> map = new HashMap<>();
        int l = 0, ans = 0;
        for(int r = 0;r<fruits.length;r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while(map.size() > 2) {
                int v = map.get(fruits[l]);
                map.put(fruits[l], v-1);
                if(v == 1) map.remove(fruits[l]);
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}