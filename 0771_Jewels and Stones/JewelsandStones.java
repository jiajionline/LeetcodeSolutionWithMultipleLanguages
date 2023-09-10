class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] jewelsMap = new int[128];
        for(char c : jewels.toCharArray()) jewelsMap[c]++;
        int[] stonesMap = new int[128];
        for(char c : stones.toCharArray()) stonesMap[c]++;
        int ans = 0;
        for(int i=0;i<stonesMap.length;i++) {
            if(jewelsMap[i] > 0) ans+=stonesMap[i];
        }
        return ans;
    }
}