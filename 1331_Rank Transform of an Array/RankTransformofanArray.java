class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        TreeSet<Integer> set = new TreeSet<>();
        // set can deduplicate
        for (int v : arr) set.add(v);
        
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : set) {
            map.put(num, rank++);
        }
        int[] ranks = new int[n];
        for (int i = 0; i < n; i++) {
            ranks[i] = map.get(arr[i]);
        }
        return ranks;
    }
}