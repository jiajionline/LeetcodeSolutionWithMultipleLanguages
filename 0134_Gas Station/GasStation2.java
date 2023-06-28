class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0;
        int currLeftGas = 0;
        int totalLeftGas = 0;
        for(int i=0;i<gas.length;i++) {
            if(currLeftGas < 0) {
                currLeftGas = 0;
                ans = i;
            }
            currLeftGas += (gas[i] - cost[i]);
            totalLeftGas += (gas[i] - cost[i]);
        }

        return totalLeftGas >= 0 ? ans : -1;
    }
}