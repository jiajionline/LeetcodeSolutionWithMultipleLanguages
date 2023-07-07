class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = 0;
        int size = triangle.size();
        for(int i=size-2;i>=0;i--) {
            List<Integer> currRow = triangle.get(i);
            List<Integer> nextRow = triangle.get(i+1);
            for(int j=0;j<currRow.size();j++) {
                currRow.set(j, Math.min(currRow.get(j) + nextRow.get(j), currRow.get(j) + nextRow.get(j+1)));
            }
        }

        return triangle.get(0).get(0);
    } 
}