class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int curr = 0;
        for(int v : nums) {
            if(v == 0) {
                if(curr > 0) {
                    list.add(curr);
                    curr = 0;
                }
                list.add(v);
            }else{
                curr++;
            }
        }
        
        if(curr > 0) list.add(curr);
        
        int ans = 1;
        for(int i=0;i<list.size();i++) {
            ans = Math.max(ans, list.get(i));
            if(list.get(i) == 0) {
                int v = 1;
                if(i > 0) v += list.get(i-1);
                if(i < list.size()-1) v+= list.get(i+1);
                ans = Math.max(ans, v);
            }
        }
        
        return ans;
    }
}