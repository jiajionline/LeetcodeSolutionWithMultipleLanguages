class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

        int ans = 0;
        for(int[] boxType : boxTypes) {
            if(truckSize <= 0) break;
            int boxes = Math.min(truckSize, boxType[0]);
            ans += boxes * boxType[1];
            truckSize -= boxes;
        }
        return ans;
    }
}