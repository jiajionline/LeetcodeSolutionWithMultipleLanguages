class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length) return -1;
        
        int start = 0;
        int totalGasLeft = 0;
        int currentGasLeft = 0;
        for(int i=0;i<gas.length;i++){
            currentGasLeft += gas[i] - cost[i];
            if(currentGasLeft<0){
                start = i+1;
                currentGasLeft = 0;
            }

            totalGasLeft += gas[i] - cost[i];
        }
        
        return totalGasLeft >=0 ? start : -1;
    }
}