class Solution {
    public boolean increasingTriplet(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int v : nums) {
            int p = lowerBound(list, v);
            if(p == list.size()){
                list.add(v);
            }else{
                list.set(p,v);
            }

            if(list.size() == 3) return true;
        }

        return false;
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while(l < r) {
            int mid = (r-l)/2 + l;
            if(list.get(mid) >= target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }

}