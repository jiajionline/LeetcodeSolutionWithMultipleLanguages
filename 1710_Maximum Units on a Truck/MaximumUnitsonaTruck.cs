public class Solution {
    public int MaximumUnits(int[][] boxTypes, int truckSize) {
        
        Array.Sort(boxTypes, (a, b) => { return b[1].CompareTo(a[1]); });
        
        var maxUnits = 0;
        for(int i=0;i<boxTypes.Length;i++)
        {
            var boxType = boxTypes[i];
            if(boxType[0] <= truckSize)
            {
                maxUnits += (boxType[0] * boxType[1]);
                truckSize -= boxType[0];
            }else{
                maxUnits += (truckSize * boxType[1]);
                truckSize = 0;
            }
            
            if(truckSize == 0) break;
        }
        
        return maxUnits;
    }
}