class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int v : arr) {
            set.add(v);
        }
        
        int index = 1;
        while(k > 0) {
            if(!set.contains(index++)){
                k--;
            }
        }
        
        return index -1;
    }
}