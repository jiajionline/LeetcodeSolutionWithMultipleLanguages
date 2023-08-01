class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int highest = Integer.MIN_VALUE;
        for(int i=heights.length-1;i>=0;i--) {
            if(heights[i] > highest){
                list.add(i);
                highest = heights[i];
            }
        }

        int[] ans = new int[list.size()];
        for(int i=0;i < ans.length;i++) {
            ans[i] = list.get(list.size()-i-1);
        }
        return ans;
    }
}